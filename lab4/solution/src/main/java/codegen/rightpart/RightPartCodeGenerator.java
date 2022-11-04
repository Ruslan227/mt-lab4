package codegen.rightpart;

import codegen.CodeGeneratorConstants;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class RightPartCodeGenerator {
    private final RightPartCodeGeneratorData data;
    private final STGroup group = new STGroupFile("src/main/java/codegen/templates/rightPart.stg");
    private final ST classTemplate = group.getInstanceOf("class");
    private final ST constructorTemplate = group.getInstanceOf("constructor");
    private final ST constructorLineTemplate = group.getInstanceOf("constructorLine");


    public RightPartCodeGenerator(RightPartCodeGeneratorData rightPartCodeGeneratorData) {
        this.data = rightPartCodeGeneratorData;
    }

    public void generate() {
        String className = generateClassName();
        String fields = generateFields();
        String constructor = generateRightPartConstructor(className);

        Path path = Paths.get(CodeGeneratorConstants.OUTPUT_DIRECTORY, className + ".java");


        try (var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            classTemplate.add("className", className);
            classTemplate.add("fields", fields);
            classTemplate.add("constructor", constructor);
            String result = classTemplate.render();
            writer.write(result);

            cleanClassTemplate();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cleanClassTemplate() {
        classTemplate.remove("className");
        classTemplate.remove("fields");
        classTemplate.remove("constructor");
    }


    public String generateClassName() {
        return "RightPart" + data.getLeftNonTerminal() + data.getId();
    }

    private String generateFields() {
        var res = new StringBuilder();
        data.getNonTerminalAmount().entrySet().forEach(entry -> generateOneNonTerminalFields(res, entry));
        res.append(CodeGeneratorConstants.NEW_LINE);

        return res.toString();
    }

    private void generateOneNonTerminalFields(StringBuilder res, Map.Entry<String, Long> nonTerminalAmount) {
        res.append("public ")
                .append(nonTerminalAmount.getKey())
                .append(CodeGeneratorConstants.SPACE);
        String objectName = nonTerminalAmount.getKey().toLowerCase();

        if (nonTerminalAmount.getValue() == 1) {
            generateOneObjectName(res, objectName);
        } else {
            generateMultipleObjectNames(res, objectName, nonTerminalAmount.getValue() - 1);
        }
    }

    private void generateOneObjectName(StringBuilder res, String objectName) {
        res.append(objectName)
                .append(0)
                .append(CodeGeneratorConstants.END_COMMAND);
    }

    private void generateMultipleObjectNames(StringBuilder res, String objectName, Long objectsAmount) {
        for (long id = 0; id < objectsAmount; id++) {
            res.append(objectName)
                    .append(id)
                    .append(CodeGeneratorConstants.COMMA)
                    .append(CodeGeneratorConstants.SPACE);
        }

        res.append(objectName)
                .append(objectsAmount)
                .append(CodeGeneratorConstants.END_COMMAND);

        res.append(CodeGeneratorConstants.NEW_LINE);
    }

    private String generateRightPartConstructor(String className) {
        var res = new StringBuilder();

        for (var entry : data.getNonTerminalAmount().entrySet()) {
            String nonTerminal = entry.getKey();

            for (long id = 0; id < entry.getValue(); id++) {
                constructorLineTemplate.add("objectName", nonTerminal.toLowerCase() + id);
                constructorLineTemplate.add("nonTerminal", nonTerminal);
                constructorLineTemplate.add("id", id);

                String result = constructorLineTemplate.render();

                res.append(CodeGeneratorConstants.NEW_LINE)
                        .append("\t")
                        .append(result);

                cleanConstructorLineTemplate();
            }
        }

        constructorTemplate.add("className", className);
        constructorTemplate.add("pureCode", res.toString());

        String ans = constructorTemplate.render();

        cleanConstructorTemplate();

        return ans;
    }

    private void cleanConstructorTemplate() {
        constructorTemplate.remove("className");
        constructorTemplate.remove("pureCode");
    }

    private void cleanConstructorLineTemplate() {
        constructorLineTemplate.remove("objectName");
        constructorLineTemplate.remove("nonTerminal");
        constructorLineTemplate.remove("id");
    }

}
