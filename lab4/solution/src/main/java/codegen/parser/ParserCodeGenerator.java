package codegen.parser;

import codegen.CodeGeneratorConstants;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParserCodeGenerator {
    private final ST classTemplate;
    private final String startNonTerminal;

    public ParserCodeGenerator(String startNonTerminal) {
        this.startNonTerminal = startNonTerminal;
        STGroup group = new STGroupFile("src/main/java/codegen/templates/parser.stg");
        classTemplate = group.getInstanceOf("class");
    }

    public void generate() {
        classTemplate.add("startNonTerminal", startNonTerminal);
        String code = classTemplate.render();

        Path path = Paths.get(CodeGeneratorConstants.OUTPUT_DIRECTORY,  "Parser.java");

        try(var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
