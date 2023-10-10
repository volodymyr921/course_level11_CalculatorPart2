package com.shpp.p2p.cs.vomelianchuk.assignment11;

import java.util.HashMap;

/**
 * Assignment11Part1.java
 * ----------------------
 * The program calculates arithmetic expressions,
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
        FormulaParse formulaParse= parseFormula(args);
        String formula = formulaParse.getFormula();

        HashMap<String, Double> variables = getVariableAndValue(args);
        double result = calculate(formula, variables);

        System.out.println("Formula: " + formula);
        System.out.println("Result: " + result + "\n");
    }

    /**
     * A method that parses a mathematical expression
     * and returns an object of the FormulaParse class.
     * @param data an array of strings that contains a mathematical expression
     * @return the object of the FormulaParse class from the resulting expression
     */
    private static FormulaParse parseFormula(String[] data) {
        String formulaParse = data[0];
        formulaParse = formulaParse.replaceAll("\\s", "");

        return new FormulaParse(formulaParse);
    }

    /**
     * The method that returns a HashMap object with variable values and their values
     * @param data array of strings, which contains variable names and their values
     * @return HashMap object with variable values and their values
     */
    private static HashMap<String, Double> getVariableAndValue(String[] data) {
        HashMap<String, Double> variables = new HashMap<>();

        for (int i = 1; i < data.length; i++) {
            String variableAndValue = data[i].replaceAll("\\s", "");
            variables.put(getVariable(variableAndValue), getValue(variableAndValue));
        }

        return variables;
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
     * Method that calculates the value of a mathematical expression using variable values.
     *
     * @param formula The formula to be calculated
     * @param variables object HashMap with variable values
     * @return The meaning of a mathematical expression using the values of variables.
     */
    private static double calculate(String formula, HashMap<String, Double> variables) {
        try {
            // Replacing each variable in the expression with its value from the HashMap object.
            for (String variable : variables.keySet()) {
                formula = formula.replaceAll(variable, String.valueOf(variables.get(variable)));
            }
            // Calculating the value of the expression using the evaluate method.
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
        /* Successive replacement of parentheses and functions
        in the expression with their numerical values. */
        while (isBrackets(formula)) {
            formula = new Brackets(formula).simplifyFormula();
        }
        while (isFunction(formula)) {
            formula = new Function(formula).simplifyFormula();
        }
        // Calculation of the numerical value of an expression using the parse method of the Calculation class.
        return new Calculation(formula).parse();
    }

    /**
     * The method checks if a mathematical expression contains parentheses.
     *
     * @param formula mathematical expression in the form of a string
     * @return true if the mathematical expression contains parentheses, false otherwise
     */
    private static boolean isBrackets(String formula) {
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks if the mathematical expression contains a function.
     *
     * @param formula mathematical expression in the form of a string
     * @return true if the mathematical expression contains functions, false otherwise
     */
    public static boolean isFunction(String formula) {
        for (int i = 0; i < formula.length(); i++) {
            if (Character.isLetter(formula.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
