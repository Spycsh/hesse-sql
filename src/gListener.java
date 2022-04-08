// Generated from C:/Users/Spycsh/Desktop/hesse-sql\g.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(gParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(gParser.PruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(gParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(gParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(gParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(gParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(gParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(gParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#region}.
	 * @param ctx the parse tree
	 */
	void enterRegion(gParser.RegionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#region}.
	 * @param ctx the parse tree
	 */
	void exitRegion(gParser.RegionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(gParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(gParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#conditionStat}.
	 * @param ctx the parse tree
	 */
	void enterConditionStat(gParser.ConditionStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#conditionStat}.
	 * @param ctx the parse tree
	 */
	void exitConditionStat(gParser.ConditionStatContext ctx);
}