package com.shpp.p2p.cs.vomelianchuk.assignment11;

/**
 * Brackets.java
 * -------------
 * A class that contains methods for simplifying
 * a mathematical expression that contains parentheses.
 */
public class Brackets {
    private String formula;
    private int pos;

    /**
     * Constructor that creates an object with a given mathematical expression.
     *
     * @param formula mathematical expression in the form of a string
     */
    public Brackets(String formula) {
        this.formula = formula;
        this.pos = 0;
    }

    /**
     * A method that simplifies a mathematical expression containing parentheses.
     *
     * @return simplified mathematical expression in the form of a string
     */
    String simplifyFormula() {
        while (pos < formula.length()) {
            if (formula.charAt(pos) == '(') {
                return parseBrackets();
            }
            pos++;
        }
        return formula;
    }

    /**
     * The method that finds the expression in parentheses and calculates its value.
     *
     * @return Simplified mathematical expression in the form of a string.
     */
    String parseBrackets() {
        int startIndex = pos;
        int i = pos;

        while (formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                startIndex = i;
            }
            i++;
        }
        int endIndex = i;

        String partFormula = formula.substring(startIndex + 1, endIndex);

        while (Assignment11Part1.isFunction(partFormula)) {
            partFormula = new Function(partFormula).simplifyFormula();
        }

        formula = formula.substring(0, startIndex) +
                new Calculation(partFormula).parse() +
                formula.substring(endIndex + 1);

        return formula;
    }
}