package com.shpp.p2p.cs.vomelianchuk.assignment11;

import com.shpp.p2p.cs.vomelianchuk.assignment11.functions.Functions;

public class Function {
    private String formula;
    private int pos;

    public Function(String formula) {
        this.formula = formula;
        this.pos = 0;
    }

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

    private void isLogarithm(int startIndex) {
        if (formula.substring(startIndex, this.pos).equals("log")) {
            if(formula.charAt(pos) == '1') pos++;
            pos++;
        }
    }

    String parseFunction(String operation, int startIndex) {
        Double number = getNumber();
        formula = formula.substring(0, startIndex) +
                new Functions().getFunctions(operation).calculateFunction(number) +
                formula.substring(this.pos);
        return formula;
    }

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
}
