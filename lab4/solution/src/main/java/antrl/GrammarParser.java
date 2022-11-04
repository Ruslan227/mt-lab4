package antrl;

import codegen.CodeGeneratorConstants;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GrammarParser {

    public static void main(String[] args) throws IOException {

        Path outputPath = Paths.get(CodeGeneratorConstants.OUTPUT_DIRECTORY);

        if (!Files.exists(outputPath)) {
            Files.createDirectories(outputPath);
        }

        Path inputPath = Paths.get("src", "main", "resources", "lab2.txt");
        List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
        String input = String.join("\n", lines);
        InputLexer inputLexer = new InputLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(inputLexer);
        InputParser inputParser = new InputParser(tokens);
        ParseTree tree = inputParser.initStart();
        ParseTreeWalker walker = new ParseTreeWalker();
        OwnInputListener listener = new OwnInputListener();
        walker.walk(listener, tree);


    }
}













