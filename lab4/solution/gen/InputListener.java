// Generated from Input.g4 by ANTLR 4.9.2
package antrl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InputParser}.
 */
public interface InputListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InputParser#initStart}.
	 * @param ctx the parse tree
	 */
	void enterInitStart(InputParser.InitStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#initStart}.
	 * @param ctx the parse tree
	 */
	void exitInitStart(InputParser.InitStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#constructors}.
	 * @param ctx the parse tree
	 */
	void enterConstructors(InputParser.ConstructorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#constructors}.
	 * @param ctx the parse tree
	 */
	void exitConstructors(InputParser.ConstructorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(InputParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(InputParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(InputParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(InputParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(InputParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(InputParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(InputParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(InputParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#targetRule}.
	 * @param ctx the parse tree
	 */
	void enterTargetRule(InputParser.TargetRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#targetRule}.
	 * @param ctx the parse tree
	 */
	void exitTargetRule(InputParser.TargetRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#rightPart}.
	 * @param ctx the parse tree
	 */
	void enterRightPart(InputParser.RightPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#rightPart}.
	 * @param ctx the parse tree
	 */
	void exitRightPart(InputParser.RightPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(InputParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(InputParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#pureCode}.
	 * @param ctx the parse tree
	 */
	void enterPureCode(InputParser.PureCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#pureCode}.
	 * @param ctx the parse tree
	 */
	void exitPureCode(InputParser.PureCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#command1}.
	 * @param ctx the parse tree
	 */
	void enterCommand1(InputParser.Command1Context ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#command1}.
	 * @param ctx the parse tree
	 */
	void exitCommand1(InputParser.Command1Context ctx);
	/**
	 * Enter a parse tree produced by {@link InputParser#command2}.
	 * @param ctx the parse tree
	 */
	void enterCommand2(InputParser.Command2Context ctx);
	/**
	 * Exit a parse tree produced by {@link InputParser#command2}.
	 * @param ctx the parse tree
	 */
	void exitCommand2(InputParser.Command2Context ctx);
}