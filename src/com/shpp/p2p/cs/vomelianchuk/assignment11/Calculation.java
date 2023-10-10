package com.shpp.p2p.cs.vomelianchuk.assignment11;

/**
 * Calculation.java
 * ----------------
 * A class that contains methods to evaluate a mathematical expression.
 */
public class Calculation {
    private int pos;
    private int character;
    private final String formula;

    /**
     * A constructor that creates an object with a given mathematical expression.
     *
     * @param formula a mathematical expression in the form of a string
     */
    public Calculation(String formula) {
        this.pos = -1;
        this.formula = formula;
    }

    /**
     * Gets the next character
     */
    void nextChar() {
        character = (++pos < formula.length()) ? formula.charAt(pos) : -1;
    }

    /**
     * Tests a character against the current character
     *
     * @param symbol The character
     * @return Symbols match or not
     */
    boolean checkSymbol(char symbol) {
        if (character == symbol) {
            nextChar();
            return true;
        }
        return false;
    }

    /**
     * This method begins the evaluation of a mathematical expression
     *
     * @return The result expression
     */
    double parse() {
        nextChar();

        return parseExpression();
    }

    /**
     * This method evaluates an expression that consists of addition and subtraction
     *
     * @return The result expression
     */
    double parseExpression() {
        double x = parseTerm();
        for (; ; ) {
            if (checkSymbol('+')) x += parseTerm();
            else if (checkSymbol('-')) x -= parseTerm();
            else return x;
        }
    }

    /**
     * This method evaluates an expression
     * that consists of multiplication and division
     *
     * @return The result expression
     */
    double parseTerm() {
        double x = parsePow();

        for (; ; ) {
            if (checkSymbol('*')) x *= parsePow();
            else if (checkSymbol('/')) x /= parsePow();
            else return x;
        }
    }

    /**
     * This method evaluates an expression
     * that consists of exponentiation
     *
     * @return The result expression
     */
    double parsePow() {
        double x = parseFactor();

        for (; ; ) {
            if (checkSymbol('^')) x = Math.pow(x, parseFactor());
            else return x;
        }
    }

    /**
     * This method evaluates expression factors such as numbers,
     * unary pluses, and minuses
     *
     * @return The result expression
     */
    double parseFactor() {
        if (checkSymbol('+')) return parseFactor();
        if (checkSymbol('-')) return -parseFactor();
        double x;

        try {
            int startPos = this.pos;
            if (Character.isDigit(character) || character == '.') {
                while (Character.isDigit(character) || character == '.') nextChar();
                x = Double.parseDouble(formula.substring(startPos, this.pos));
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException exception) {
            System.err.println("Invalid formula, contains characters that do not correspond to numbers or mathematical functions");
            return Double.NaN;
        }

        return x;
    }
}
