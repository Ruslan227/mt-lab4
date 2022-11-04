package control.table;

import base.BasicOperations;

import java.io.Serializable;
import java.util.*;

/**
 * Describes LR(0)-item entity
 */
public class LRZeroItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String ruleLeftPart;
    private final List<String> ruleRightPart;
    private Set<String> lookahead = new HashSet<>();
    private int itemPointer = 0;


    public LRZeroItem(String ruleLeftPart, List<String> ruleRightPart) {
        this.ruleLeftPart = ruleLeftPart;
        this.ruleRightPart = ruleRightPart;

        if (BasicOperations.isRightPartEpsilon(ruleRightPart)) {
            itemPointer++;
        }
    }

    private LRZeroItem(String ruleLeftPart, List<String> ruleRightPart, int itemPointer) {
        this.ruleLeftPart = ruleLeftPart;
        this.ruleRightPart = ruleRightPart;
        this.itemPointer = itemPointer;
    }

    public LRZeroItem incItem() {
        var res = new LRZeroItem(ruleLeftPart, ruleRightPart, itemPointer + 1);
        res.setLookahead(lookahead);

        return res;
    }

    public void merge(LRZeroItem lrZeroItem) {
        lookahead.addAll(lrZeroItem.getLookahead());
    }

    public String getNextToItemToken() {
        return (itemPointer == ruleRightPart.size())? "" : ruleRightPart.get(itemPointer);
    }

    public boolean isNextLexemeNonTerminal() {
        return !isItemInTheEnd() && BasicOperations.isNonTerminal(getNextToItemToken());
    }

    public boolean isItemInTheEnd() {
        return itemPointer == ruleRightPart.size();
    }

    public Set<String> getLookahead() {
        return lookahead;
    }

    public void setLookahead(Set<String> lookahead) {
        this.lookahead = new HashSet<>();
        this.lookahead.addAll(lookahead);
    }

    public List<String> getRuleRightPart() {
        return ruleRightPart;
    }

    public Rule getRule() {
        return new Rule(ruleLeftPart, ruleRightPart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LRZeroItem that = (LRZeroItem) o;
        return itemPointer == that.itemPointer &&
                Objects.equals(ruleLeftPart, that.ruleLeftPart) &&
                Objects.equals(ruleRightPart, that.ruleRightPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleLeftPart, ruleRightPart, itemPointer);
    }
}
