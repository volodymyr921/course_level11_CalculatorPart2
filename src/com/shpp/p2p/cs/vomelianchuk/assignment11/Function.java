package com.shpp.p2p.cs.vomelianchuk.assignment11;

import com.shpp.p2p.cs.vomelianchuk.assignment11.functions.Functions;

/**
 * Function.java
 * -------------
 * A class that contains methods for simplifying
 * a mathematical expression that contains functions.
 */
public class Function {
    private String formula;
    private int pos;

    /**
     * A constructor that creates an object with a given mathematical expression.
     *
     * @param formula a mathematical expression in the form of a string
     */
    public Function(String formula) {
        this.formula = formula;
        this.pos = 0;
    }

    /**
     * A method that simplifies a mathematical expression containing functions.
     *
     * @return a simplified mathematical expression in the form of a string
     */
    String simplifyFormula() {
        while (pos < formula.length()) {
            if (Character.isLetter(formula.charAt(pos))) {
                int startIndex = pos;
                while (Character.isLetter(formula.charAt(pos))) pos++;
                isLogarithm(startIndex);

                String operation = formula.substring(startIndex, this.pos);
                return parseFunction(operation, startIndex);
            }
            pos++;
        }
        return formula;
    }

    /**
     * A method that finds a function argument and calculates the value of the function.
     *
     * @param operation the name of the function as a string
     * @param startIndex the starting position of the function in the expression
     * @return a simplified mathematical expression in the form of a string
     */
    String parseFunction(String operation, int startIndex) {
        Double number = getNumber();
        formula = formula.substring(0, startIndex) +
                new Functions().getFunctions(operation).calculateFunction(number) +
                formula.substring(this.pos);
        return formula;
    }

    /**
     * A method that finds the function argument in an expression.
     *
     * @return function argument as a number
     */
    private Double getNumber() {
        int startPos = this.pos;
        if (Character.isDigit(formula.charAt(pos)) || formula.charAt(pos) == '.' || formula.charAt(pos) == '-') {
            pos++;
            while (pos < formula.length() - 1 && Character.isDigit(formula.charAt(pos)) || formula.charAt(pos) == '.') pos++;

            if(pos == formula.length() - 1) {
               this.pos++;
            }

            return Double.parseDouble(formula.substring(startPos, this.pos));
        }
        return null;
    }

    /**
     * A method that tests whether a function is a logarithm.
     *
     * @param startIndex the starting position of the function in the expression
     */
    private void isLogarithm(int startIndex) {
        if (formula.substring(startIndex, this.pos).equals("log")) {
            if(formula.charAt(pos) == '1') pos++;
            pos++;
        }
    }
}
