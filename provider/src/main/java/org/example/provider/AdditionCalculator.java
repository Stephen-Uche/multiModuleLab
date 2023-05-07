package org.example.provider;

import org.example.service.Calculator;
import org.example.service.annotation.Calculation;

@Calculation("Addition")
public class AdditionCalculator implements Calculator {

    public AdditionCalculator() {
        System.out.println("Number Added = "+ calculateNumbers(25,5));
    }


    @Override
    public Integer calculateNumbers(Integer a, Integer b) {

        return a + b;
    }

}
