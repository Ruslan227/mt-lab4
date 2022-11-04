package codegen.rightpart;

import java.util.HashMap;
import java.util.Map;

public class RightPartCodeGeneratorData {
    private final Map<String, Long> nonTerminalAmount = new HashMap<>();
    private String leftNonTerminal;
    private Long id;

    public void updateLeftNonTerminalId(Long id) { // String nonTerminalText
        this.id = id;
    }

    public void updateRightPartNonTerminalAmount(String nonTerminalText) {
        nonTerminalAmount.computeIfPresent(nonTerminalText, (k, v) -> v + 1L);
        nonTerminalAmount.putIfAbsent(nonTerminalText, 1L);
    }

    public void clear() {
        leftNonTerminal = null;
        nonTerminalAmount.clear();
    }

    public Long getId() {
        return id;
    }

    public String getLeftNonTerminal() {
        return leftNonTerminal;
    }

    public void setLeftNonTerminal(String leftNonTerminal) {
        this.leftNonTerminal = leftNonTerminal;
    }

    public Map<String, Long> getNonTerminalAmount() {
        return nonTerminalAmount;
    }

}
