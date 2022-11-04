package control.table.command;

import control.State;

import java.io.Serializable;
import java.util.Objects;

public class UnexpectedLexemeException implements Command, Serializable { //extends RuntimeException
    private static final long serialVersionUID = 1L;
    private final String message;

    public UnexpectedLexemeException(String message) {
        this.message = message;
    }


    @Override
    public boolean doAction(State state) {
        throw new RuntimeException("unexpected lexeme: " + state.getInputLine());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnexpectedLexemeException that = (UnexpectedLexemeException) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "     x    ";
    }
}
