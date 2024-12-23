package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import gen.CustomerServiceDSLParser;
import gen.CustomerServiceDSLBaseListener;

public class CustomerServiceDSLListenerImpl extends CustomerServiceDSLBaseListener {
    private Map<String, String> responses;
    private Map<String, String> transitions;
    private Map<String, String> autoTransitions;
    private Map<String, Map<String, String>> conditionalTransitions;

    public CustomerServiceDSLListenerImpl(Map<String, String> responses, Map<String, String> transitions, Map<String, String> autoTransitions, Map<String, Map<String, String>> conditionalTransitions) {
        this.responses = responses;
        this.transitions = transitions;
        this.autoTransitions = autoTransitions;
        this.conditionalTransitions = conditionalTransitions;
    }

    @Override
    public void enterStateDefinition(CustomerServiceDSLParser.StateDefinitionContext ctx) {
        String state = ctx.ID().getText();
        String response = String.valueOf(ctx.response().STRING());

        responses.put(state,response);
    }

    @Override
    public void enterTransitionRule(CustomerServiceDSLParser.TransitionRuleContext ctx) {
        String keyword = ctx.keyword().getText();
        String fromState = ctx.ID(0).getText();
        String toState = ctx.ID(1).getText();
        transitions.put(fromState + ":" + keyword, toState);
    }

    @Override
    public void enterConditionalTransition(CustomerServiceDSLParser.ConditionalTransitionContext ctx) {
        String keyword = ctx.keyword().getText();
        String fromState = ctx.ID(0).getText();
        String conditionKey = ctx.condition().ID().getText();
        String conditionValue = ctx.condition().STRING().getText().replace("\"", "");
        String toState = ctx.ID(1).getText();

        String transitionKey = fromState + ":" + keyword;
        conditionalTransitions
                .computeIfAbsent(transitionKey, k -> new HashMap<>())
                .put(conditionKey + "==" + conditionValue, toState);
    }

    @Override
    public void enterAutoTransition(CustomerServiceDSLParser.AutoTransitionContext ctx) {
        String fromState = ctx.ID(1).getText();
        String toState = ctx.ID(0).getText();
        autoTransitions.put(fromState, toState);
    }
}