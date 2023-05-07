package org.example.provider;

import org.example.service.Calculator;
import org.example.service.annotation.Calculation;

@Calculation("Subtraction")
public class SubtractionCalculator implements Calculator {
    public SubtractionCalculator() {
        System.out.println("Number Subtracted = "+ calculateNumbers(25,5));
    }

    @Override
    public Integer calculateNumbers(Integer a, Integer b) {
        return a - b;
    }
}
