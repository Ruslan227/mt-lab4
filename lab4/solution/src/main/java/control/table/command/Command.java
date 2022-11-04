package control.table.command;

import control.State;

public interface Command {
    // was it Reduce or not
    boolean doAction(State state);
}
