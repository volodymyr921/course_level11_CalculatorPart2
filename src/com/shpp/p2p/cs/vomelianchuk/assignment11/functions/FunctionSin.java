package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionSin implements IAction {
    @Override
    public double calculateFunction(double number) {
        return Math.sin(number);
    }
}