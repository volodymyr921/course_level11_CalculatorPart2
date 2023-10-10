package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionSqrt implements IAction {
    /**
     * Calculates the value of the square root for a given number.
     *
     * @param number the number for which the function is calculated
     * @return square root value for a given number
     */
    @Override
    public double calculateFunction(double number) {
        return Math.sqrt(number);
    }
}
