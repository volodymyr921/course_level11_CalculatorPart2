package com.shpp.p2p.cs.vomelianchuk.assignment11.functions;

import java.util.HashMap;

public class Functions {
    private HashMap<String, IAction> functions = new HashMap<>();

    public Functions() {
        functions.put("sin", new FunctionSin());
        functions.put("cos", new FunctionCos());
        functions.put("tan", new FunctionTan());
        functions.put("atan", new FunctionAtan());
        functions.put("log2", new FunctionLog2());
        functions.put("log10", new FunctionLog10());
        functions.put("sqrt", new FunctionSqrt());
    }

    public IAction getFunctions(String key) {
        return functions.get(key);
    }
}
