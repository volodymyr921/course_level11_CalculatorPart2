package com.shpp.p2p.cs.vomelianchuk.assignment11;

/**
 * TestCalculator.java
 * -------------------
 * The class used to test the Assignment11Part1 class.
 */
public class TestCalculator {
    public static void main(String[] args) {
        
        Assignment11Part1.main(new String[]{"3 - a*(5 /(-4 - 1)) / b / (3-4)", "a = -3", "b = 3"});
        Assignment11Part1.main(new String[]{"3 - (a*5) /4 - 1 * b + 3-4", "a = 2", "b = 3"});
        Assignment11Part1.main(new String[]{"3 - (a*(4*(4+1)))", "a = 2"});
        Assignment11Part1.main(new String[]{"1 + cos(a) - sin(-1)", "a = 2", "b = 3"});
        Assignment11Part1.main(new String[]{"5-sin(45*cos(a))", "a = 2"});

        Assignment11Part1.main(new String[]{"1+(2 +3*(4+5-sin(45*cos(4))))/a", "a = 2"});
        Assignment11Part1.main(new String[]{"-((-3)^-2 - (a*(4*(4^b)))^2)", "a = 2", "b = 3"});
    }
}