package org.example.provider;

import org.example.service.Calculator;
import org.example.service.annotation.Calculation;

import java.util.Scanner;

@Calculation("Addition")
public class AdditionCalculator implements Calculator {
    public AdditionCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number ");
        Integer numb1 = scanner.nextInt();
        System.out.println("Enter second number ");
        Integer numb2 = scanner.nextInt();
        Integer result = numb1 + numb2;
        System.out.println("Result = "+ result);

    }

    @Override
    public Integer calculateNumbers(Integer a, Integer b) {

        return  a + b;

    }

}







