package org.example.provider;

import org.example.service.Calculator;
import org.example.service.annotation.Calculation;

@Calculation("Multiplication")
public class MultiplicationCalculator implements Calculator {
    public MultiplicationCalculator() {
        System.out.println("Number Multiplied = " + calculateNumbers(25,5));
    }

    @Override
    public Integer calculateNumbers(Integer a, Integer b) {
        return a * b;
    }
}
