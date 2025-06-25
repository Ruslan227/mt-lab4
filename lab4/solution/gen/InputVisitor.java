// Generated from Input.g4 by ANTLR 4.9.2
package antrl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InputParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InputVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InputParser#initStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitStart(InputParser.InitStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#constructors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructors(InputParser.ConstructorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(InputParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(InputParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(InputParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(InputParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#targetRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetRule(InputParser.TargetRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#rightPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightPart(InputParser.RightPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(InputParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#pureCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureCode(InputParser.PureCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#command1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand1(InputParser.Command1Context ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#command2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand2(InputParser.Command2Context ctx);
}