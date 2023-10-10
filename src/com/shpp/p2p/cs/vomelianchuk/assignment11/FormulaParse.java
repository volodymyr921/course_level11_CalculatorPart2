package com.shpp.p2p.cs.vomelianchuk.assignment11;

/**
 * FormulaParse.java
 * -----------------
 * A class that contains a mathematical expression as a string.
 */
public class FormulaParse {
    private final String formula;

    /**
     * Constructor that creates an object with a specified mathematical expression.
     *
     * @param formula mathematical expression in the form of a string
     */
    public FormulaParse(String formula) {
        this.formula = formula;
    }

    /**
     * Method that returns a mathematical expression as a string.
     *
     * @return mathematical expression in the form of a string
     */
    public String getFormula() {
        return formula;
    }

}
