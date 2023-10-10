package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionSin implements IAction {
    /**
     * Calculates the value of the sine for a given number.
     *
     * @param number the number for which the function is calculated
     * @return sine value for a given number
     */
    @Override
    public double calculateFunction(double number) {
        return Math.sin(number);
    }
}