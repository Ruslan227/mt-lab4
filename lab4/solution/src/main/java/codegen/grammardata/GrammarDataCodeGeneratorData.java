package codegen.grammardata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrammarDataCodeGeneratorData {
    private final Map<String, String> rightPartClassName = new HashMap<>();
    private final Map<String, List<String>> nonTerminalRightPartClassName = new HashMap<>();
    private String rightPartTmp;
    private String leftNonTerminal;

    private void updateNonTerminalRightPartClassName(String rightPartClassName) {
        var col = new ArrayList<String>();
        col.add(rightPartClassName);

        nonTerminalRightPartClassName.computeIfPresent(leftNonTerminal, (key, rightPartClassNames) -> {
            rightPartClassNames.addAll(col);
            return rightPartClassNames;
        });
        nonTerminalRightPartClassName.putIfAbsent(leftNonTerminal, col);
    }

    public void setLeftNonTerminal(String leftNonTerminal) {
        this.leftNonTerminal = leftNonTerminal;
    }

    public void setRightPartTmp(String rightPartTmp) {
        this.rightPartTmp = rightPartTmp;
    }

    public Map<String, String> getRightPartClassName() {
        return rightPartClassName;
    }

    public void setRightPartClassName(String rightPartClassName) {
        this.rightPartClassName.put(rightPartTmp, rightPartClassName);
        updateNonTerminalRightPartClassName(rightPartClassName);
        rightPartTmp = null;
        leftNonTerminal = null;
    }

    public Map<String, List<String>> getNonTerminalRightPartClassName() {
        return nonTerminalRightPartClassName;
    }
}
