package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionLog10 implements IAction {
    @Override
    public double calculateFunction(double number) {
        return Math.log10(number);
    }
}
