package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

public class FunctionLog2 implements IAction {
    @Override
    public double calculateFunction(double number) {
        return Math.log10(number) / Math.log10(2);
    }
}