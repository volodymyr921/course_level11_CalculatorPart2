package com.shpp.p2p.cs.vomelianchuk.assignment11;

import java.util.HashMap;

/**
 * Assignment10Part1.java
 * ----------------------
 * The program calculates simple arithmetic expressions,
 * accepts it and returns a value
 */
public class Assignment11Part1 {
    /**
     * Calculates an expression with parameters
     * and outputs the result to the console
     *
     * @param args The expression and its parameters
     */
    public static void main(String[] args) {
        FormulaTree formulaTree = parseFormula(args);
        System.out.println(calculate(formulaTree.getFormula()) + "\n");
    }

    private static FormulaTree parseFormula(String[] data) {

        String formulaParse = data[0];
        formulaParse = formulaParse.replaceAll("\\s", "");

        // TODO: Заміна змінних їх значеннями
        HashMap<String, Double> variables = new HashMap<>();
        for (int i = 1; i < data.length; i++) {
            String variableAndValue = data[i].replaceAll("\\s", "");
            variables.put(getVariable(variableAndValue), getValue(variableAndValue));
        }
        for (String variable : variables.keySet()) {
            formulaParse = formulaParse.replaceAll(variable, String.valueOf(variables.get(variable)));
        }

        return new FormulaTree(formulaParse);
    }

    /**
     * Gets the parameter name
     *
     * @param variableAndValue The string with the parameter and its value
     * @return The parameter name
     */
    private static String getVariable(String variableAndValue) {
        return variableAndValue.split("=")[0];
    }

    /**
     * The value of the parameter is obtained
     *
     * @param variableAndValue The string with the parameter and its value
     * @return Parameter value
     */
    private static Double getValue(String variableAndValue) {
        return Double.valueOf(variableAndValue.split("=")[1]);
    }

    /**
     * Evaluates the given expression with its parameters
     *
     * @param formula The formula to be calculated
     * @return The result of the expression when the parameters are substituted
     */
    private static double calculate(String formula) {
        try {
            return evaluate(formula);
        } catch (Exception e) {
            System.err.println("Incorrect calculate");
            return Double.NaN;
        }
    }

    /**
     * Evaluates an expression with numbers without parameters,
     * respecting the precedence of signs
     *
     * @param formula The formula to be calculated
     * @return The result of the expression
     */
    private static double evaluate(String formula) {
        while (isBrackets(formula)) {
            formula = new Brackets(formula).simplifyFormula();
        }
        while (isFunction(formula)) {
            formula = new Function(formula).simplifyFormula();
        }
        return new Calculation(formula).parse();
    }

    public static boolean isFunction(String formula) {
        for (int i = 0; i < formula.length(); i++) {
            if (Character.isLetter(formula.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBrackets(String formula) {
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                return true;
            }
        }
        return false;
    }
}
