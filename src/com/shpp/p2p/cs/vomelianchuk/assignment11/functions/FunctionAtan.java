package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionAtan implements IAction {
    /**
     * Calculates the value of the arc tangent for a given number.
     *
     * @param number the number for which the function is calculated
     * @return arc tangent value for a given number
     */
    @Override
    public double calculateFunction(double number) {
        return Math.atan(number);
    }
}
