package control.table.command;

import control.State;

import java.io.Serializable;
import java.util.Objects;

public class Move implements Command, Serializable {
    private static final long serialVersionUID = 1L;
    private final int conditionPointer;

    public Move(int conditionPointer) {
        this.conditionPointer = conditionPointer;
    }

    @Override
    public boolean doAction(State state) {
        state.setPointer(conditionPointer);
        return false;
    }

    protected int getConditionPointer() {
        return conditionPointer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return conditionPointer == move.conditionPointer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conditionPointer);
    }

    @Override
    public String toString() {
        int p = conditionPointer;
        var numS = (p < 10)? "0" + p : String.valueOf(p);
        return "   m," + numS + "   ";
    }
}
