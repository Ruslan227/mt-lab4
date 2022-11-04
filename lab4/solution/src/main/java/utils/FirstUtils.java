package utils;

import base.BasicOperations;
import base.Constants;
import control.table.Rule;

import java.io.Serializable;
import java.util.*;

public class FirstUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    private final UtilsData data;
    private final Map<String, Set<String>> grammarTokenFirst = new HashMap<>();
    private Set<String> computingNonTerminalFirst = new HashSet<>();


    public FirstUtils(UtilsData data) {
        this.data = data;
        computeFirst();
    }

    private void computeFirst() {
        data.getNonTerminals().forEach(this::addNonTerminalFirst);
        data.getTerminals().forEach(this::addTerminalFirst);
        addTerminalFirst(Constants.LAST_TOKEN);
        computingNonTerminalFirst = null; // to clean memory
    }

    private void addTerminalFirst(String terminal) {
        if (terminal.equals(Constants.EPS)) {
            return;
        }

        var first = new TreeSet<String>();
        first.add(terminal);
        grammarTokenFirst.put(terminal, first);
    }

    private void addNonTerminalFirst(String nonTerminal) {
        if (grammarTokenFirst.containsKey(nonTerminal)) {
            return;
        }

        if (computingNonTerminalFirst.contains(nonTerminal)) {
            return;
        }

        computingNonTerminalFirst.add(nonTerminal);

        grammarTokenFirst.put(nonTerminal, new HashSet<>());
        addFirstFromNonTerminalRightParts(nonTerminal);

        computingNonTerminalFirst.remove(nonTerminal);
    }

    private void addFirstFromNonTerminalRightParts(String nonTerminal) {
        Set<List<String>> rightParts = data.getNonTerminalRightParts().get(nonTerminal);
        Set<String> first = new HashSet<>();

        rightParts.forEach(rightPart -> first.addAll(addFirstFromRule(new Rule(nonTerminal, rightPart))));

        grammarTokenFirst.computeIfPresent(nonTerminal, (key, oldValue) -> {
            oldValue.addAll(first);
            return oldValue;
        });
    }

    private Set<String> addFirstFromRule(Rule rule) {
        String firstLexemeInRightPart = rule.getRightPart().get(0);

        if (BasicOperations.isNonTerminal(firstLexemeInRightPart)) {
            addNonTerminalFirst(firstLexemeInRightPart);

            return grammarTokenFirst.get(firstLexemeInRightPart);
        } else {
            var res = new TreeSet<String>();

            if (firstLexemeInRightPart.equals(Constants.EPS)) {
                return res;
            }

            res.add(firstLexemeInRightPart);

            return res;
        }
    }

    public Map<String, Set<String>> getGrammarTokenFirst() {
        return grammarTokenFirst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FirstUtils that = (FirstUtils) o;

        if (!Objects.equals(data, that.data)) return false;
        if (!grammarTokenFirst.equals(that.grammarTokenFirst))
            return false;
        return Objects.equals(computingNonTerminalFirst, that.computingNonTerminalFirst);
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + grammarTokenFirst.hashCode();
        result = 31 * result + (computingNonTerminalFirst != null ? computingNonTerminalFirst.hashCode() : 0);
        return result;
    }
}
