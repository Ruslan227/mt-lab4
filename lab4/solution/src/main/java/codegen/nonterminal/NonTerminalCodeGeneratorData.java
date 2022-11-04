package codegen.nonterminal;

import java.util.ArrayList;
import java.util.List;

public class NonTerminalCodeGeneratorData {
    private final List<String> fields = new ArrayList<>();
    private final List<String> constructorCommands = new ArrayList<>();
    private String nonTerminal;
    private StringBuilder constructorCommandBuffer = new StringBuilder();

    public void addField(String typeAndVarName) {
        fields.add(typeAndVarName);
    }

    public void addTmpConstructorCommand(String commandPart) {
        constructorCommandBuffer.append(commandPart);
    }

    public void addCommandFromBuffer() {
        constructorCommands.add(constructorCommandBuffer.toString());
        constructorCommandBuffer = new StringBuilder();
    }

    public List<String> getConstructorCommands() {
        return constructorCommands;
    }

    public List<String> getFields() {
        return fields;
    }

    public String getNonTerminal() {
        return nonTerminal;
    }

    public void setNonTerminal(String nonTerminal) {
        this.nonTerminal = nonTerminal;
    }

    public void clear() {
        fields.clear();
        nonTerminal = null;
        constructorCommands.clear();
        constructorCommandBuffer = new StringBuilder();
    }
}
