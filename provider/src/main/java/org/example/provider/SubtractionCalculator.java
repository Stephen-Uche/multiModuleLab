package org.example.provider;

import org.example.service.Calculator;

public class SubtractionCalculator implements Calculator {
    public SubtractionCalculator() {
        System.out.println("Number Subtracted");
    }

    @Override
    public int calculateNumbers(int a, int b) {
        return a - b;
    }
}
