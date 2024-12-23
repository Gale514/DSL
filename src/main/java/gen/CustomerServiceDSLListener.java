package gen;// Generated from E:/Project/DSL/src/main/antlr4/CustomerServiceDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CustomerServiceDSLParser}.
 */
public interface CustomerServiceDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(CustomerServiceDSLParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(CustomerServiceDSLParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CustomerServiceDSLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CustomerServiceDSLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#stateDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStateDefinition(CustomerServiceDSLParser.StateDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#stateDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStateDefinition(CustomerServiceDSLParser.StateDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#transitionRule}.
	 * @param ctx the parse tree
	 */
	void enterTransitionRule(CustomerServiceDSLParser.TransitionRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#transitionRule}.
	 * @param ctx the parse tree
	 */
	void exitTransitionRule(CustomerServiceDSLParser.TransitionRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#conditionalTransition}.
	 * @param ctx the parse tree
	 */
	void enterConditionalTransition(CustomerServiceDSLParser.ConditionalTransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#conditionalTransition}.
	 * @param ctx the parse tree
	 */
	void exitConditionalTransition(CustomerServiceDSLParser.ConditionalTransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#autoTransition}.
	 * @param ctx the parse tree
	 */
	void enterAutoTransition(CustomerServiceDSLParser.AutoTransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#autoTransition}.
	 * @param ctx the parse tree
	 */
	void exitAutoTransition(CustomerServiceDSLParser.AutoTransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#response}.
	 * @param ctx the parse tree
	 */
	void enterResponse(CustomerServiceDSLParser.ResponseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#response}.
	 * @param ctx the parse tree
	 */
	void exitResponse(CustomerServiceDSLParser.ResponseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CustomerServiceDSLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CustomerServiceDSLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomerServiceDSLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(CustomerServiceDSLParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomerServiceDSLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(CustomerServiceDSLParser.KeywordContext ctx);
}