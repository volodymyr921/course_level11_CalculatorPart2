package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionLog10 implements IAction {
    /**
     * Calculates the value of the logarithm to base 10 for a given number.
     *
     * @param number the number for which the function is calculated
     * @return logarithm to base 10 value for a given number
     */
    @Override
    public double calculateFunction(double number) {
        return Math.log10(number);
    }
}
