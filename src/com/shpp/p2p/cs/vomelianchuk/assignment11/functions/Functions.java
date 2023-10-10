package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

import java.util.HashMap;

/**
 * A class that contains various functions
 * and returns objects that implement the IAction interface.
 */
public class Functions {
    private final HashMap<String, IAction> functions = new HashMap<>();

    /**
     * Constructor of the Functions class.
     * Create objects of various classes
     * that implement the IAction interface and adds
     * them to the HashMap functions object with the corresponding keys.
     */
    public Functions() {
        functions.put("sin", new FunctionSin());
        functions.put("cos", new FunctionCos());
        functions.put("tan", new FunctionTan());
        functions.put("atan", new FunctionAtan());
        functions.put("log2", new FunctionLog2());
        functions.put("log10", new FunctionLog10());
        functions.put("sqrt", new FunctionSqrt());
    }

    /**
     * A method that returns an object that implements
     * the IAction interface corresponding to the passed key.
     *
     * @param key the key that corresponds to the object to return
     * @return an object that implements the IAction interface corresponding to the passed key
     */
    public IAction getFunctions(String key) {
        return functions.get(key);
    }
}
