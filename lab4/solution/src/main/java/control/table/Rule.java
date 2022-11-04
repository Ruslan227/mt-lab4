package control.table;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents context-sensitive grammar rule
 */
public class Rule implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String leftPart;
    private final List<String> rightPart;

    public Rule(String leftPart, List<String> rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    public String getLeftPart() {
        return leftPart;
    }

    public List<String> getRightPart() {
        return rightPart;
    }

    @Override
    public String toString() {
        return leftPart + " -> " + String.join(" ", rightPart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return Objects.equals(leftPart, rule.leftPart) && Objects.equals(rightPart, rule.rightPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftPart, rightPart);
    }
}
