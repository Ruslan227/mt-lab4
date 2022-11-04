package utils;

import java.io.Serializable;
import java.util.*;

public class UtilsData implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<String, Set<List<String>>> nonTerminalRightParts = new HashMap<>();
    private final Set<String> nonTerminals = new HashSet<>();
    private final Set<String> terminals = new HashSet<>();


    public UtilsData() {
    }

    public void updateNonTerminalRightParts(String nonTerminal, Set<List<String>> rightParts) {
        nonTerminalRightParts.computeIfPresent(nonTerminal, (key, oldVal) -> {
            oldVal.addAll(rightParts);
            return oldVal;
        });

        nonTerminalRightParts.putIfAbsent(nonTerminal, rightParts);
    }

    public void updateNonTerminals(String nonTerminal) {
        nonTerminals.add(nonTerminal);
    }

    public void updateTerminals(String terminal) {
        terminals.add(terminal);
    }


    public Map<String, Set<List<String>>> getNonTerminalRightParts() {
        return nonTerminalRightParts;
    }

    public Set<String> getNonTerminals() {
        return nonTerminals;
    }

    public Set<String> getTerminals() {
        return terminals;
    }


}
