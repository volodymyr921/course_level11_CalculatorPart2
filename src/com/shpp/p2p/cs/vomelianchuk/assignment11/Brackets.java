package com.shpp.p2p.cs.vomelianchuk.assignment11;

public class Brackets {
    private String formula;
    private int pos;

    public Brackets(String formula) {
        this.formula = formula;
        this.pos = 0;
    }

    String simplifyFormula() {
        while (pos < formula.length()) {
            if (formula.charAt(pos) == '(') {
                return parseBrackets();
            }
            pos++;
        }
        return formula;
    }

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
        formula = formula.substring(0, startIndex) +
                new Calculation(partFormula).parse() +
                formula.substring(endIndex + 1);
        return formula;
    }
}