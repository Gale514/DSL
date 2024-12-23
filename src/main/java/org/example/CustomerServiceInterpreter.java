package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import gen.CustomerServiceDSLParser;
import gen.CustomerServiceDSLLexer;

public class CustomerServiceInterpreter {
    private Map<String, String> responses = new HashMap<>();
    private Map<String, String> transitions = new HashMap<>();
    private Map<String, String> autoTransitions = new HashMap<>();
    private Map<String, Map<String, String>> conditionalTransitions = new HashMap<>();
    private Map<String, String> context = new HashMap<>();
    private String currentState = "greeting";
    private static final int TIMEOUT = 30000; // 30 seconds
    private Timer timer;

    public void loadScript(String script) {
        CharStream input = CharStreams.fromString(script);
        CustomerServiceDSLLexer lexer = new CustomerServiceDSLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CustomerServiceDSLParser parser = new CustomerServiceDSLParser(tokens);
        ParseTree tree = parser.script();
        ParseTreeWalker walker = new ParseTreeWalker();
        CustomerServiceDSLListenerImpl listener = new CustomerServiceDSLListenerImpl(responses, transitions, autoTransitions, conditionalTransitions);
        walker.walk(listener, tree);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        resetTimer();
        while (true) {
            System.out.println(responses.getOrDefault(currentState, "Sorry, I don't understand."));
            if (autoTransitions.containsKey(currentState)) {
                currentState = autoTransitions.get(currentState);
                continue;
            }
            String input = scanner.nextLine().toLowerCase();
            resetTimer();


            String transitionKey = currentState + ":" + input;

            // Check conditional transitions
            boolean transitioned = false;
            if (conditionalTransitions.containsKey(transitionKey)) {
                Map<String, String> conditions = conditionalTransitions.get(transitionKey);
                for (String condition : conditions.keySet()) {
                    String[] parts = condition.split("==");
                    String conditionKey = parts[0];
                    String conditionValue = parts[1];
                    if (context.getOrDefault(conditionKey, "").equals(conditionValue)) {
                        currentState = conditions.get(condition);
                        transitioned = true;
                        break;
                    }
                }
            }

            // Check normal transitions
            if (!transitioned && transitions.containsKey(transitionKey)) {
                currentState = transitions.get(transitionKey);
                transitioned = true;
            }

            // Handle unknown input
            if (!transitioned) {
                currentState = "unknown";
            }
        }
    }

    private void resetTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("It seems you've been inactive for a while. Is there anything else I can help you with?");
                currentState = "greeting";
            }
        }, TIMEOUT);
    }

    public static void main(String[] args) {
        // Print current working directory
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // Read Script.txt file content
        String script = "";
        try {
            script = new String(Files.readAllBytes(Paths.get("src/main/resources/Script.txt")));
        } catch (IOException e) {
            System.err.println("Error reading script file: " + e.getMessage());
            e.printStackTrace(); // Print detailed error message
            System.exit(1);
        }

        CustomerServiceInterpreter interpreter = new CustomerServiceInterpreter();
        interpreter.loadScript(script);
        interpreter.context.put("user", "admin"); // Set context information
        interpreter.start();
    }
}