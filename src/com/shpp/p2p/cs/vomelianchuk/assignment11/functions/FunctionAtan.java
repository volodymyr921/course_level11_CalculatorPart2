package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionAtan implements IAction {
    @Override
    public double calculateFunction(double number) {
        return Math.atan(number);
    }
}
