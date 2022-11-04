package control.table.command;

import control.State;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.List;

public class Shift extends Move implements Command, Serializable {
    private static final long serialVersionUID = 1L;

    public Shift(int moveToState) {
        super(moveToState);
    }

    @Override
    public boolean doAction(State state) {
        ArrayDeque<String> work = state.getWork();
        List<String> input = state.getInputLine();

        assert input.size() > 0;

        work.add(input.get(0));
        input = input.subList(1, input.size());

//        state.setWork(work);
        state.setInputLine(input);
        state.setPointer(getConditionPointer());

        return false;
    }

    @Override
    public String toString() {
        int p = super.getConditionPointer();
        var numS = (p < 10)? "0" + p : String.valueOf(p);
        return "   s," + numS + "   ";
    }
}
