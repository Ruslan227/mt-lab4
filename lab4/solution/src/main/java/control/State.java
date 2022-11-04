package control;

import base.Constants;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.List;


public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayDeque<String> work = new ArrayDeque<>(); //Stack
    private final ArrayDeque<Object> objects = new ArrayDeque<>();
    private final String startNonTerminal;
    private List<String> inputLine; // TODO: del
    private int pointer = 0;

    public State(String startNonTerminal) {
        this.startNonTerminal = startNonTerminal;
    }

    public boolean doesParsingEnd() {
        return work.size() == 1 && work.getFirst().equals(startNonTerminal) &&
                inputLine.size() == 1 && inputLine.get(0).equals(Constants.LAST_TOKEN);
    }

    public String getCurrentLexeme() {
        return inputLine.get(0);
    }

    public List<String> getInputLine() {
        return inputLine;
    }

    public void setInputLine(List<String> inputLine) {
        this.inputLine = inputLine;
    }

    public ArrayDeque<String> getWork() {
        return work;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public ArrayDeque<Object> getObjects() {
        return objects;
    }
}
