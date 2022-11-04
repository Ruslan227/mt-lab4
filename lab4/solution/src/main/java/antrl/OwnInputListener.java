package antrl;

import base.BasicOperations;
import base.Constants;
import codegen.CodeGeneratorConstants;
import codegen.grammardata.GrammarDataCodeGenerator;
import codegen.grammardata.GrammarDataCodeGeneratorData;
import codegen.nonterminal.NonTerminalCodeGenerator;
import codegen.nonterminal.NonTerminalCodeGeneratorData;
import codegen.parser.ParserCodeGenerator;
import codegen.rightpart.RightPartCodeGenerator;
import codegen.rightpart.RightPartCodeGeneratorData;
import control.table.ControlTable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import utils.FirstUtils;
import utils.LookaheadUtils;
import utils.UtilsData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OwnInputListener extends InputBaseListener {
    private final RightPartCodeGeneratorData rightPartCodeGeneratorData = new RightPartCodeGeneratorData();
    private final NonTerminalCodeGeneratorData nonTerminalCodeGeneratorData = new NonTerminalCodeGeneratorData();
    private final GrammarDataCodeGeneratorData grammarDataCodeGeneratorData = new GrammarDataCodeGeneratorData();
    private final UtilsData utilsData = new UtilsData();
    private final Map<String, Long> leftNonTerminalId = new HashMap<>();
//    private final Map<String, Set<List<String>>> nonTerminalRightParts = new HashMap<>();
    private final Set<String> nonTerminalsWithEpsilonRules = new HashSet<>();
    private final Set<String> nonTerminalsInRightPart = new HashSet<>(); // to check input
    private final List<String> rightPartTmp = new ArrayList<>();
    private String startNonTerminal;

    private void checkNullAndDo(TerminalNode arg, Consumer<TerminalNode> action) {
        if (arg != null) {
            action.accept(arg);
        }
    }

    @Override
    public void enterInitStart(InputParser.InitStartContext ctx) {
        super.enterInitStart(ctx);
    }


    @Override
    public void exitInitStart(InputParser.InitStartContext ctx) {
        for (var nonTerminal : utilsData.getNonTerminals()) {
            var path = Paths.get(CodeGeneratorConstants.OUTPUT_DIRECTORY, nonTerminal + ".java");
            addNonTerminalClassCloseParenthesis(path);
        }

        var controlTable = constructControlTable();
        serializeControlTable(controlTable);

        var parserCodeGenerator = new ParserCodeGenerator(startNonTerminal);
        parserCodeGenerator.generate();
    }

    private ControlTable constructControlTable() {
        var first = new FirstUtils(utilsData);
        var lookahead = new LookaheadUtils(
                nonTerminalsWithEpsilonRules,
                first.getGrammarTokenFirst()
        );

        return new ControlTable(
                startNonTerminal,
                utilsData.getNonTerminalRightParts(),
                lookahead,
                new TreeSet<>(first.getGrammarTokenFirst().keySet()),
                nonTerminalsWithEpsilonRules);
    }

    private void serializeControlTable(ControlTable controlTable) {
        try (var outputStream = new FileOutputStream(CodeGeneratorConstants.OUTPUT_DIRECTORY + "controlTable.txt");
             var objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(controlTable);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addNonTerminalClassCloseParenthesis(Path path) {
        try {
            Files.write(path, "}".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterConstructors(InputParser.ConstructorsContext ctx) {
        super.enterConstructors(ctx);
    }


    @Override
    public void enterClassName(InputParser.ClassNameContext ctx) {
        nonTerminalCodeGeneratorData.setNonTerminal(ctx.NON_TERMINAL().getText());
    }

    @Override
    public void exitClassName(InputParser.ClassNameContext ctx) {
        var nonTerminalCodeGenerator = new NonTerminalCodeGenerator(nonTerminalCodeGeneratorData);
        nonTerminalCodeGenerator.generateClassAndFields();
        nonTerminalCodeGeneratorData.clear();
    }

    @Override
    public void enterArguments(InputParser.ArgumentsContext ctx) {
        super.enterArguments(ctx);
    }


    @Override
    public void enterArgument(InputParser.ArgumentContext ctx) {
        nonTerminalCodeGeneratorData.addField(ctx.TYPE().getText() + " " + ctx.VAR_NAME().getText());
    }


    @Override
    public void enterRules(InputParser.RulesContext ctx) {
        super.enterRules(ctx);
    }

    @Override
    public void exitRules(InputParser.RulesContext ctx) {
        var parserCodeGenerator = new GrammarDataCodeGenerator(grammarDataCodeGeneratorData);
        parserCodeGenerator.generate();
    }

    @Override
    public void enterTargetRule(InputParser.TargetRuleContext ctx) {
        var nonTerminalText = ctx.NON_TERMINAL().getText();

        grammarDataCodeGeneratorData.setLeftNonTerminal(nonTerminalText);

        leftNonTerminalId.computeIfPresent(nonTerminalText, (k, v) -> v + 1L);
        leftNonTerminalId.putIfAbsent(nonTerminalText, 1L);

        rightPartCodeGeneratorData.updateLeftNonTerminalId(leftNonTerminalId.get(nonTerminalText));
        rightPartCodeGeneratorData.setLeftNonTerminal(nonTerminalText);

        startNonTerminal = startNonTerminal == null ? nonTerminalText : startNonTerminal;

        utilsData.updateNonTerminals(nonTerminalText);

        if (BasicOperations.isEpsilon(ctx.rightPart().getText())) {
            nonTerminalsWithEpsilonRules.add(nonTerminalText);
        }
    }

    @Override
    public void exitTargetRule(InputParser.TargetRuleContext ctx) {
        String nonTerminal = ctx.NON_TERMINAL().getText();
        Set<List<String>> rightParts = new HashSet<>();
        rightParts.add(new ArrayList<>(rightPartTmp));

        grammarDataCodeGeneratorData.setRightPartTmp(String.join("", rightPartTmp));

        rightPartTmp.clear();

        utilsData.updateNonTerminalRightParts(nonTerminal, rightParts);

        generateRightPartClass();

        generateNonTerminalConstructor(nonTerminal);
    }

    private void generateNonTerminalConstructor(String nonTerminal) {
        nonTerminalCodeGeneratorData.setNonTerminal(nonTerminal);
        String rightPartClassName = "RightPart" + nonTerminal + leftNonTerminalId.get(nonTerminal);
        var nonTerminalCodeGenerator = new NonTerminalCodeGenerator(nonTerminalCodeGeneratorData);
        nonTerminalCodeGenerator.generateConstructor(rightPartClassName);
        nonTerminalCodeGeneratorData.clear();
    }

    private void generateRightPartClass() {
        var rightPartCodeGenerator = new RightPartCodeGenerator(rightPartCodeGeneratorData);
        grammarDataCodeGeneratorData.setRightPartClassName(rightPartCodeGenerator.generateClassName());
        rightPartCodeGenerator.generate();
        rightPartCodeGeneratorData.clear();
    }

    @Override
    public void enterRightPart(InputParser.RightPartContext ctx) {
        checkNullAndDo(ctx.TERMINAL(), terminalNode -> {
            String terminalText = terminalNode.getText();
            var parsedTerminalText = terminalText.substring(1, terminalText.length() - 1);
//            terminals.add(parsedTerminalText);
            utilsData.updateTerminals(parsedTerminalText);
            rightPartTmp.add(parsedTerminalText);
        });

        checkNullAndDo(ctx.NON_TERMINAL(), terminalNode -> {
            String nonTerminalText = terminalNode.getText();

            nonTerminalsInRightPart.add(nonTerminalText);
            rightPartTmp.add(nonTerminalText);
            rightPartCodeGeneratorData.updateRightPartNonTerminalAmount(nonTerminalText);
        });

        checkNullAndDo(ctx.EPS(), terminalNode -> {
            rightPartTmp.add(terminalNode.getText());
        });
    }


    @Override
    public void enterCode(InputParser.CodeContext ctx) {
        super.enterCode(ctx);
    }


    @Override
    public void enterPureCode(InputParser.PureCodeContext ctx) {
        super.enterPureCode(ctx);
    }

    @Override
    public void enterCommand2(InputParser.Command2Context ctx) {
        String command = parseCommand2(ctx);
        nonTerminalCodeGeneratorData.addTmpConstructorCommand(command);
    }

    private String parseCommand2(InputParser.Command2Context ctx) {
        String commandText = ctx.TERMINAL().getText();
        var code = new StringBuilder();

        for (int i = 0; i < commandText.length(); i++) {
            char c = commandText.charAt(i);
            if (c != Constants.SPECIAL_SYMBOL) {
                code.append(c);
            }
        }

        code.append(ctx.END_COMMAND().getText());

        return code.toString();
    }

    @Override
    public void enterCommand1(InputParser.Command1Context ctx) {
        addCommandLexemeToData(
                ctx,
                ctx.VAR_NAME(0),
                ctx.EQ(),
                ctx.VAR_NAME(1),
                ctx.NON_TERMINAL_FIELD(),
                ctx.END_COMMAND()
        );
    }


    private void addCommandLexemeToData(InputParser.Command1Context ctx, TerminalNode... terminalNodes) {
        for (var terminalNode : terminalNodes) {
            if (terminalNode != null) {
                if (isNonTerminalField(ctx, terminalNode)) {
                    parseAndAddNonTerminalField(terminalNode);
                } else {
                    nonTerminalCodeGeneratorData.addTmpConstructorCommand(terminalNode.getText());
                }
            }
        }
    }

    private boolean isNonTerminalField(InputParser.Command1Context ctx, TerminalNode currentTerminalNode) {
        return ctx.NON_TERMINAL_FIELD() != null &&
                currentTerminalNode.getText().equals(ctx.NON_TERMINAL_FIELD().getText());
    }

    private void parseAndAddNonTerminalField(TerminalNode terminalNode) {
        String nonTerminalFieldText = terminalNode.getText();

        Pattern pattern = Pattern.compile("([A-Z]+[a-z0-9]*)\\[([0-9]+)](.+)");
        Matcher matcher = pattern.matcher(nonTerminalFieldText);

        if (matcher.find()) {
            addNonTerminalFieldToData(matcher);
        } else {
            throw new RuntimeException("unexpected nonTerminal field " + nonTerminalFieldText);
        }
    }

    private void addNonTerminalFieldToData(Matcher matcher) {
        nonTerminalCodeGeneratorData.addTmpConstructorCommand("rightPart.");
        nonTerminalCodeGeneratorData.addTmpConstructorCommand(matcher.group(1).toLowerCase());
        nonTerminalCodeGeneratorData.addTmpConstructorCommand(matcher.group(2));
        nonTerminalCodeGeneratorData.addTmpConstructorCommand(matcher.group(3));
    }

    @Override
    public void exitCommand1(InputParser.Command1Context ctx) {
        nonTerminalCodeGeneratorData.addCommandFromBuffer();
    }

    @Override
    public void exitCommand2(InputParser.Command2Context ctx) {
        nonTerminalCodeGeneratorData.addCommandFromBuffer();
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }


    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }

    public Set<String> getNonTerminals() {
        return utilsData.getNonTerminals();
    }

    public Set<String> getNonTerminalsInRightPart() {
        return nonTerminalsInRightPart;
    }
}
