package codegen.grammardata;

import codegen.CodeGeneratorConstants;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class GrammarDataCodeGenerator {
    private final GrammarDataCodeGeneratorData data;
    private final STGroup group = new STGroupFile("src/main/java/codegen/templates/grammarData.stg");
    private final ST classTemplate = group.getInstanceOf("class");
    private final ST rightPartConstructorTemplate = group.getInstanceOf("rightPartConstructor");
    private final ST switchRightPartTemplate = group.getInstanceOf("switchRightPart");
    private final ST caseTemplate = group.getInstanceOf("case");

    public GrammarDataCodeGenerator(GrammarDataCodeGeneratorData data) {
        this.data = data;
    }

    public void generate() {
        String rightPartConstructor = generateRightPartConstructor();
        String switchRightPart = generateSwitchRightPart();
        classTemplate.add("rightPartConstructor", rightPartConstructor);
        classTemplate.add("switchRightPart", switchRightPart);

        String res = classTemplate.render();

        Path path = Paths.get(CodeGeneratorConstants.OUTPUT_DIRECTORY,  "GrammarData.java");

        try(var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateRightPartConstructor() {
        var rightPartConstructor = new StringBuilder(rightPartConstructorTemplate.render());
        Map<String, String> rightPartClassName = data.getRightPartClassName();

        rightPartClassName.forEach((rightPart, className) -> {
            rightPartConstructor.append("\n\tentry(\"")
                    .append(rightPart)
                    .append("\", ")
                    .append(className)
                    .append("::new),");
        });

        rightPartConstructor.delete(rightPartConstructor.length() - 1, rightPartConstructor.length());
        rightPartConstructor.append("\n");
        rightPartConstructor.append(");\n");

        return rightPartConstructor.toString();
    }

    private String generateSwitchRightPart() {
        var cases = new StringBuilder();
        Map<String, List<String>> nonTerminalsRightPartClassNames = data.getNonTerminalRightPartClassName();

        for (var entry : nonTerminalsRightPartClassNames.entrySet()) {
            for (var rightPartConstructorName : entry.getValue()) {
                String case1 = generateCase(entry.getKey(), rightPartConstructorName);
                cases.append(case1);
            }
        }

        switchRightPartTemplate.add("cases", cases.toString());

        return switchRightPartTemplate.render();
    }

    private String generateCase(String nonTerminal, String rightPartClassName) {
        caseTemplate.add("nonTerminal", nonTerminal);
        caseTemplate.add("rightPartClassName", rightPartClassName);
        String res = caseTemplate.render();

        cleanCaseTemplate();

        return res;
    }

    private void cleanCaseTemplate() {
        caseTemplate.remove("nonTerminal");
        caseTemplate.remove("rightPartClassName");
    }
}
