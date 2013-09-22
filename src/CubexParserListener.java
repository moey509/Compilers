// Generated from CubexParser.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CubexParser}.
 */
public interface CubexParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CubexParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull CubexParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull CubexParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#classgrammar}.
	 * @param ctx the parse tree
	 */
	void enterClassgrammar(@NotNull CubexParser.ClassgrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#classgrammar}.
	 * @param ctx the parse tree
	 */
	void exitClassgrammar(@NotNull CubexParser.ClassgrammarContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#iface}.
	 * @param ctx the parse tree
	 */
	void enterIface(@NotNull CubexParser.IfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#iface}.
	 * @param ctx the parse tree
	 */
	void exitIface(@NotNull CubexParser.IfaceContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull CubexParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull CubexParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#kcont}.
	 * @param ctx the parse tree
	 */
	void enterKcont(@NotNull CubexParser.KcontContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#kcont}.
	 * @param ctx the parse tree
	 */
	void exitKcont(@NotNull CubexParser.KcontContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(@NotNull CubexParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(@NotNull CubexParser.FuncContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull CubexParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull CubexParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(@NotNull CubexParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(@NotNull CubexParser.ExprsContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#ttuple}.
	 * @param ctx the parse tree
	 */
	void enterTtuple(@NotNull CubexParser.TtupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#ttuple}.
	 * @param ctx the parse tree
	 */
	void exitTtuple(@NotNull CubexParser.TtupleContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(@NotNull CubexParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(@NotNull CubexParser.TypesContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull CubexParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull CubexParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#tscheme}.
	 * @param ctx the parse tree
	 */
	void enterTscheme(@NotNull CubexParser.TschemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#tscheme}.
	 * @param ctx the parse tree
	 */
	void exitTscheme(@NotNull CubexParser.TschemeContext ctx);

	/**
	 * Enter a parse tree produced by {@link CubexParser#tcont}.
	 * @param ctx the parse tree
	 */
	void enterTcont(@NotNull CubexParser.TcontContext ctx);
	/**
	 * Exit a parse tree produced by {@link CubexParser#tcont}.
	 * @param ctx the parse tree
	 */
	void exitTcont(@NotNull CubexParser.TcontContext ctx);
}