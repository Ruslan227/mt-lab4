package control.table;

import java.io.Serializable;
import java.util.*;

/**
 * Describes condition cell of control table
 * <p>
 *     It consists of LR(0)-items that are available in current step
 * </p>
 * @see LRZeroItem
 */
public class ConditionCell implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Set<LRZeroItem> lrZeroItems = new HashSet<>();

    public ConditionCell(ConditionCell baseConditionCell) {
        this.lrZeroItems.addAll(baseConditionCell.getLrZeroItems());
    }

    public ConditionCell() {
    }

    public void merge(ConditionCell conditionCell) {
        var lrZeroItems1 = conditionCell.getLrZeroItems();

        for (var lrZeroItem1 : lrZeroItems1) {
            for (var lrZeroItem : lrZeroItems) {
                if (lrZeroItem1.equals(lrZeroItem)) {
                    lrZeroItem.merge(lrZeroItem1);
                }
            }
        }
    }

    public void add(LRZeroItem lrZeroItem) {
        lrZeroItems.add(lrZeroItem);
    }

    public Set<LRZeroItem> getLrZeroItems() {
        return lrZeroItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConditionCell that = (ConditionCell) o;
        return Objects.equals(lrZeroItems, that.lrZeroItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lrZeroItems);
    }
}
