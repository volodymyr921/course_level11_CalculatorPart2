package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionCos implements IAction {
    /**
     * Calculates the value of the cosine for a given number.
     *
     * @param number the number for which the function is calculated
     * @return cosine value for a given number
     */
    @Override
    public double calculateFunction(double number) {
        return Math.cos(number);
    }
}
