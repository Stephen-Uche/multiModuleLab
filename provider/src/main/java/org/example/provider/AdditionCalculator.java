package org.example.provider;

import org.example.service.Calculator;

public class AdditionCalculator implements Calculator {

    public AdditionCalculator() {


        System.out.println("Number Addition Created "+ calculateNumbers(20,10));
        System.out.println();
    }

    @Override
    public int calculateNumbers(int a, int b) {
         return a + b;
    }
}
