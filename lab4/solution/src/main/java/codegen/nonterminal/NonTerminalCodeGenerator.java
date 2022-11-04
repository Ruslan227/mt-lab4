package codegen.nonterminal;

import codegen.CodeGeneratorConstants;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NonTerminalCodeGenerator {
    private final NonTerminalCodeGeneratorData data;
    private final STGroup group = new STGroupFile("src/main/java/codegen/templates/nonTerminal.stg");
    private final ST oneFieldTemplate = group.getInstanceOf("oneField");
    private final ST classDeclarationTemplate = group.getInstanceOf("classDeclaration");
    private final ST constructorDeclarationTemplate = group.getInstanceOf("constructorDeclaration");

    public NonTerminalCodeGenerator(NonTerminalCodeGeneratorData data) {
        this.data = data;
    }

    public void generateClassAndFields() {
        var path = Paths.get(CodeGeneratorConstants.OUTPUT_DIRECTORY, data.getNonTerminal() + ".java");

        try (var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            classDeclarationTemplate.add("className", data.getNonTerminal());
            writer.write(classDeclarationTemplate.render());
            classDeclarationTemplate.remove("className");

            for (var field : data.getFields()) {
                oneFieldTemplate.add("typeAndVarName", field);
                writer.write(oneFieldTemplate.render());
                writer.newLine();
                oneFieldTemplate.remove("typeAndVarName");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateConstructor(String rightPartClassName) {
        var path = Paths.get(CodeGeneratorConstants.OUTPUT_DIRECTORY, data.getNonTerminal() + ".java");

        if (!Files.exists(path)) {
            generateClassAndFields();
        }

        var code = new StringBuilder();
        code.append("\n");

        constructorDeclarationTemplate.add("className", data.getNonTerminal());
        constructorDeclarationTemplate.add("rightPartClassName", rightPartClassName);
        code.append(constructorDeclarationTemplate.render());
        cleanConstructorDeclarationTemplate();

        for (var constructorCommand : data.getConstructorCommands()) {
            code.append(CodeGeneratorConstants.NEW_LINE).append("\t\t").append(constructorCommand);
        }

        code.append("\n\t}\n");

        try {
            Files.write(path, code.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cleanConstructorDeclarationTemplate() {
        constructorDeclarationTemplate.remove("className");
        constructorDeclarationTemplate.remove("rightPartClassName");
    }
}
