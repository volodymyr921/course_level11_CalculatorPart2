package com.shpp.p2p.cs.vomelianchuk.assignment11;

public class TestCalculator {
    public static void main(String[] args) {
        Assignment11Part1.main(new String[]{"3 - a*(5 /(-4 - 1)) / b / (3-4)", "a = -3", "b = 3"});
        Assignment11Part1.main(new String[]{"3 - (a*5) /4 - 1 * b + 3-4", "a = 2", "b = 3"});
        Assignment11Part1.main(new String[]{"3 - (a*(4*(4+1)))", "a = 2"});
        Assignment11Part1.main(new String[]{"-((-3)^-2 - (a*(4*(4+1)))^2)", "a = 2"});
    }
}