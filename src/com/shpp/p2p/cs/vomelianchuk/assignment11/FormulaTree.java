package com.shpp.p2p.cs.vomelianchuk.assignment11;

import java.util.HashMap;

public class FormulaTree {
    private String formula;
    private double number;
    private double function;

    public FormulaTree(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        System.out.println(formula);
        return formula;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getFunction() {
        return function;
    }

    public void setFunction(double function) {
        this.function = function;
    }
}
