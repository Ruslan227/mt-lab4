package control.table;

import base.BasicOperations;
import base.Constants;
import control.State;
import control.table.command.*;
import utils.LookaheadUtils;

import java.io.Serializable;
import java.util.*;

public class ControlTable implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<ConditionCell> conditions = new ArrayList<>();
    private final Map<String, Integer> grammarTokenMappingIndex = new HashMap<>();
    private final List<List<Command>> commands = new ArrayList<>();
    private final LookaheadUtils lookaheadUtils;
    private final Map<String, Set<List<String>>> nonTerminalRightParts;
    private final Set<String> grammarTokens;
    private final String startNonTerminal;
    private State state;
    private final Set<String> nonTerminalsWithEpsilonRules;
    private transient GrammarDataI grammarData;

    public ControlTable(String startNonTerminal,
                        Map<String, Set<List<String>>> nonTerminalRightParts,
                        LookaheadUtils lookaheadUtils,
                        Set<String> grammarTokens,
                        Set<String> nonTerminalsWithEpsilonRules) {

        this.lookaheadUtils = lookaheadUtils;
        this.nonTerminalRightParts = nonTerminalRightParts;
        this.grammarTokens = grammarTokens;
        this.startNonTerminal = startNonTerminal;
        this.nonTerminalsWithEpsilonRules = nonTerminalsWithEpsilonRules;
        state = new State(startNonTerminal);

        fillSymbolMappingIndex(grammarTokens); // TODO: изменить, чтобы были терминальные токены, а не конкретные значения
    }

    public void setGrammarData(GrammarDataI grammarData) {
        this.grammarData = grammarData;
    }

    public void clearParsingState() {
        state = new State(startNonTerminal);
    }

    public void buildTable() { // build after grammarData would be set
        build(getFirstCell(startNonTerminal));
    }

    private Command findEpsReduce(ConditionCell conditionCell) {
        var lrZeroItems = conditionCell.getLrZeroItems();

        for (var lrZeroItem : lrZeroItems) {
            var expectedLexeme = lrZeroItem.getNextToItemToken();
            if (isNonTerminalWithEpsilonRule(lrZeroItem)) {
                var rule = new Rule(expectedLexeme, List.of(Constants.EPS));
                return new Reduce(rule, grammarData);
            }
        }

        return new UnexpectedLexemeException("rule not found");
    }

    private boolean isNonTerminalWithEpsilonRule(LRZeroItem lrZeroItem) {
        return lrZeroItem.isNextLexemeNonTerminal() && nonTerminalsWithEpsilonRules.contains(lrZeroItem.getNextToItemToken());
    }

    // контракт: state must be set
    public Object parse(String input) { // TODO: вытащить в сгенеренный парсер
        List<String> input1 = List.of(input.split(" "));
        state.setInputLine(input1);


        var previousConditionPointers = new ArrayDeque<Integer>();

        while (!state.doesParsingEnd()) { //.doesInputFinished()
            previousConditionPointers.push(state.getPointer());
            int commandIndex = grammarTokenMappingIndex.get(state.getCurrentLexeme());

            Command command = commands.get(state.getPointer()).get(commandIndex);

            if (command.getClass().getName().equals("control.table.command.UnexpectedLexemeException")) {
                command = findEpsReduce(conditions.get(state.getPointer()));
            }

            if (command.doAction(state)) { // после свертки обязательно будет Move
                Reduce reduce = (Reduce) command;

                if (!BasicOperations.isRightPartEpsilon(reduce.getRightPart())) {
                    for (int i = 0; i < reduce.getRightPart().size(); i++) {
                        previousConditionPointers.pop();
                    }
                    state.setPointer(previousConditionPointers.getFirst());
                }

                if (state.doesParsingEnd()) {
                    break;
                }

                int indexToMoveTo = grammarTokenMappingIndex.get(reduce.getLeftNonTerminal());
                commands.get(state.getPointer()).get(indexToMoveTo).doAction(state);
            }
        }


        if (state.doesParsingEnd()) {
            return state.getObjects().getFirst();
        }

        throw new RuntimeException("parsing error: can't parse the entire line");
    }


    private void fillSymbolMappingIndex(Set<String> grammarTokens) {
        int i = 0;

        for (var grammarToken : grammarTokens) {
            grammarTokenMappingIndex.put(grammarToken, i);
            i++;
        }
    }


    public void build(ConditionCell startConditionCell) {
        conditions.add(startConditionCell);
        commands.add(new ArrayList<>(Collections.nCopies(grammarTokenMappingIndex.size(), null)));
        fillReductions(0);
        boolean changes = true;

        for (int conditionInd = 0; conditionInd < conditions.size() || changes; conditionInd++) {
            changes = false;

            for (var grammarToken : grammarTokens) {
                var newConditionCell = goTo(conditions.get(conditionInd), grammarToken);

                if (!newConditionCell.getLrZeroItems().isEmpty()) {
                    addNewConditionCell(newConditionCell, conditionInd, grammarToken); // || changes
                    changes = true;
                }
            }

        }

        fillErrors();

//        printTable();
    }

    private void printTable() {
        var m = new TreeMap<Integer, String>();

        for (var entry : grammarTokenMappingIndex.entrySet()) {
            m.put(entry.getValue(), entry.getKey());
        }

        System.out.print("   ##      ");

        for (int i = 0; i < m.size(); i++) {
            System.out.print(m.get(i) + "     ##      ");
        }
        // ## f ## E ## + ##
        System.out.println();

        for (int i = 0; i < commands.size(); i++) {
            System.out.printf("%03d", i);

            for (var command : commands.get(i)) {
                System.out.printf("## %s ", command.toString());
            }

            System.out.println("##");
        }
    }

    private void fillErrors() {
        for (List<Command> command : commands) {
            for (var c : grammarTokenMappingIndex.keySet()) {
                int j = grammarTokenMappingIndex.get(c);
                if (command.get(j) == null) {
                    command.set(j, new UnexpectedLexemeException("problem token: " + c));
                }
            }
        }
    }

    private ConditionCell goTo(ConditionCell conditionCell, String grammarToken) {
        var newConditionCell = new ConditionCell();

        for (var lrZeroItem : conditionCell.getLrZeroItems()) {
            if (lrZeroItem.getNextToItemToken().equals(grammarToken)) {
                newConditionCell.add(lrZeroItem.incItem());
            }
        }

        return cycleClosure(newConditionCell);
    }

    private void fillReductions(int conditionInd) {
        var conditionCell = conditions.get(conditionInd);

        for (var lrZeroItem : conditionCell.getLrZeroItems()) {
            if (lrZeroItem.isItemInTheEnd()) {
                addReductionsFromLookahead(lrZeroItem, conditionInd);
            }
        }
    }

    private void addReductionsFromLookahead(LRZeroItem lrZeroItem, int conditionInd) {
        Set<String> lookahead = lrZeroItem.getLookahead();

        while (commands.size() < conditions.size()) { // TODO: delete this block
            commands.add(new ArrayList<>(Collections.nCopies(grammarTokenMappingIndex.size(), null)));
        }

        for (var lookaheadToken : lookahead) {
            int grammarTokenInd = grammarTokenMappingIndex.get(lookaheadToken);

            if (commands.get(conditionInd).get(grammarTokenInd) == null) {
                commands.get(conditionInd).set(grammarTokenInd, new Reduce(lrZeroItem.getRule(), grammarData));
            }
        }
    }


    private void addNewConditionCell(ConditionCell newConditionCell, int prevConditionInd, String grammarToken) {
        boolean wasAlreadyAdded = false;
        int currentConditionInd = -1;

        for (int conditionInd = 0; conditionInd < conditions.size(); conditionInd++) {
            var conditionCell = conditions.get(conditionInd);

            if (conditionCell.equals(newConditionCell)) { // areAllLRZeroEquivalent

                conditionCell.merge(newConditionCell);

                currentConditionInd = conditionInd;
                wasAlreadyAdded = true;
                break;
            }
        }

        if (!wasAlreadyAdded) {
            conditions.add(newConditionCell);
            commands.add(new ArrayList<>(Collections.nCopies(grammarTokenMappingIndex.size(), null)));
            currentConditionInd = conditions.size() - 1;
        }

        fillReductions(currentConditionInd);


        int grammarTokenInd = grammarTokenMappingIndex.get(grammarToken);

        if (BasicOperations.isNonTerminal(grammarToken)) {
            commands.get(prevConditionInd).set(grammarTokenInd, new Move(currentConditionInd));
        } else {
            commands.get(prevConditionInd).set(grammarTokenInd, new Shift(currentConditionInd));
        }
    }

    private ConditionCell getFirstCell(String startNonTerminal) {
        Set<List<String>> rightParts = nonTerminalRightParts.get(startNonTerminal);
        var firstCell = new ConditionCell();
        Set<String> lookahead = new HashSet<>();
        lookahead.add(Constants.LAST_TOKEN);

        for (var rightPart : rightParts) {
            var lrZeroItemTmp = new LRZeroItem(startNonTerminal, rightPart);
            lrZeroItemTmp.setLookahead(lookahead);
            firstCell.add(lrZeroItemTmp);
        }

        return cycleClosure(firstCell);
    }

    private ConditionCell cycleClosure(ConditionCell baseConditionCell) {
        int size1 = 0;

        while (size1 != baseConditionCell.getLrZeroItems().size()) {
            size1 = baseConditionCell.getLrZeroItems().size();
            baseConditionCell = closure(baseConditionCell);
        }

        return baseConditionCell;
    }

    private ConditionCell closure(ConditionCell baseConditionCell) {
        var newConditionCell = new ConditionCell(baseConditionCell);

        for (var lrZeroItem : baseConditionCell.getLrZeroItems()) {

            if (lrZeroItem.isNextLexemeNonTerminal()) {
                addNewLrZeroItems(newConditionCell, lrZeroItem.getNextToItemToken());
            }
        }

        return newConditionCell;
    }

    private void addNewLrZeroItems(ConditionCell baseConditionCell, String nonTerminal) {
        Set<String> lookahead = getLookaheadFromPrevLrZeroItems(baseConditionCell, nonTerminal);
        Set<List<String>> rightParts = nonTerminalRightParts.get(nonTerminal);

        addTrivialLookahead(rightParts, lookahead, nonTerminal);

        for (var rightPart : rightParts) {
            var lrZeroItemTmp = new LRZeroItem(nonTerminal, rightPart);
            lrZeroItemTmp.setLookahead(lookahead);
            baseConditionCell.add(lrZeroItemTmp);
        }
    }

    private Set<String> getLookaheadFromPrevLrZeroItems(ConditionCell baseConditionCell, String nonTerminal) {
        Set<String> lookahead = new HashSet<>();

        for (var lrZeroItem : baseConditionCell.getLrZeroItems()) {
            var rightPart = lrZeroItem.getRuleRightPart();
            for (int i = 1; i < rightPart.size(); i++) {
                if (rightPart.get(i - 1).equals(nonTerminal)) {
                    var lk = lookaheadUtils.getLookahead(rightPart.subList(i, rightPart.size()), lrZeroItem.getLookahead());
                    lookahead.addAll(lk);
                }
            }
            if (rightPart.size() == 1) {
                if (rightPart.get(0).equals(nonTerminal)) {
                    var lk = lookaheadUtils.getLookahead(new ArrayList<>(), lrZeroItem.getLookahead());
                    lookahead.addAll(lk);
                }
            }
        }

        return lookahead;
    }

    private void addTrivialLookahead(Set<List<String>> rightParts, Set<String> lookahead, String nonTerminal) {
        for (var rightPart : rightParts) {
            for (int i = 1; i < rightPart.size(); i++) {
                if (rightPart.get(i - 1).equals(nonTerminal) && BasicOperations.isTerminal(rightPart.get(i))) {
                    lookahead.add(rightPart.get(i));
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControlTable that = (ControlTable) o;
        return conditions.equals(that.conditions) && commands.equals(that.commands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conditions, commands);
    }
}
