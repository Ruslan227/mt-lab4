package control.table.command;

import base.BasicOperations;
import control.State;
import control.table.GrammarDataI;
import control.table.Rule;

import java.io.Serializable;
import java.util.*;

public class Reduce implements Command, Serializable {
    private static final long serialVersionUID = 1L;
    private final Rule rule;
    private final int rightPartTerminalsAmount;
    private static GrammarDataI grammarData;

    public Reduce(Rule rule, GrammarDataI grammarData) {
        this.rule = rule;
        Reduce.grammarData = grammarData;
        rightPartTerminalsAmount = countRightPartTerminals();
    }

    private int countRightPartTerminals() {
        List<String> rightPart = rule.getRightPart();
        int terminalsAmount = 0;

        for (var lexeme : rightPart) {
            if (BasicOperations.isTerminal(lexeme) && !BasicOperations.isEpsilon(lexeme)) {
                terminalsAmount++;
            }
        }

        return terminalsAmount;
    }

    @Override
    public boolean doAction(State state) {
        List<String> rightPart = rule.getRightPart();
        ArrayDeque<String> work = state.getWork();
        ArrayDeque<Object> objects = state.getObjects();

        Map<String, List<Object>> rightPartArguments = new HashMap<>();

        if (!BasicOperations.isRightPartEpsilon(rightPart)) {
            for (int i = rightPart.size() - 1; i > -1; i--) { // skipping all terminals
                assert work.getLast().equals(rightPart.get(i));

                if (BasicOperations.isNonTerminal(work.getLast())) {
                    addRightPartArgument(rightPartArguments, work.getLast(), objects.getLast());
                    objects.removeLast();
                }
                work.removeLast();
            }
        }

        work.add(rule.getLeftPart());


        String rightPartConcatenated = String.join("",rightPart);
        Object rightPartObj = grammarData.getRightPartConstructor().get(rightPartConcatenated).apply(rightPartArguments);

        objects.add(grammarData.reduceFromRightPart(rightPartObj));

        return true;
    }

    public String getLeftNonTerminal() {
        return rule.getLeftPart();
    }

    private void addRightPartArgument(Map<String, List<Object>> rightPartArguments, String nonTerminal, Object object) {
        var objects = new ArrayList<Object>();
        objects.add(object);

        rightPartArguments.computeIfPresent(nonTerminal, (key, objs) -> {
            objs.addAll(objects);
            return objs;
        });
        rightPartArguments.putIfAbsent(nonTerminal, objects);
    }

    public int getRightPartTerminalsAmount() {
        return rightPartTerminalsAmount;
    }

    public List<String> getRightPart() {
        return rule.getRightPart();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reduce reduce = (Reduce) o;
        return rightPartTerminalsAmount == reduce.rightPartTerminalsAmount && Objects.equals(rule, reduce.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule, rightPartTerminalsAmount);
    }

    @Override
    public String toString() {
        return "     r    ";
    }
}
