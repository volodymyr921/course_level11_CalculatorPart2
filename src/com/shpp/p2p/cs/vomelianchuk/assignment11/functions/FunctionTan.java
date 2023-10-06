package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionTan implements IAction {
    @Override
    public double calculateFunction(double number) {
        return Math.tan(number);
    }
}