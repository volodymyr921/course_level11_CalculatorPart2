package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionTan implements IAction {
    /**
     * Calculates the value of the tangent for a given number.
     *
     * @param number the number for which the function is calculated
     * @return tangent value for a given number
     */
    @Override
    public double calculateFunction(double number) {
        return Math.tan(number);
    }
}