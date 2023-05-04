package org.example.provider;

import org.example.service.Calculator;

public class MultiplicationCalculator implements Calculator {
    public MultiplicationCalculator() {
        System.out.println("Number Multiplied");
    }

    @Override
    public int calculateNumbers(int a, int b) {
        return a * b;
    }
}
