// Generated from C:/Users/Spycsh/Desktop/hesse-sql\g.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrule(gParser.PruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(gParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(gParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(gParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#region}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegion(gParser.RegionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(gParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#conditionStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStat(gParser.ConditionStatContext ctx);
}