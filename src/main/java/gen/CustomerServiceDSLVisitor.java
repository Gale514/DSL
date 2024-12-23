package gen;// Generated from E:/Project/DSL/src/main/antlr4/CustomerServiceDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CustomerServiceDSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CustomerServiceDSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(CustomerServiceDSLParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CustomerServiceDSLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#stateDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateDefinition(CustomerServiceDSLParser.StateDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#transitionRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitionRule(CustomerServiceDSLParser.TransitionRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#conditionalTransition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalTransition(CustomerServiceDSLParser.ConditionalTransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#autoTransition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoTransition(CustomerServiceDSLParser.AutoTransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#response}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResponse(CustomerServiceDSLParser.ResponseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(CustomerServiceDSLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomerServiceDSLParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(CustomerServiceDSLParser.KeywordContext ctx);
}