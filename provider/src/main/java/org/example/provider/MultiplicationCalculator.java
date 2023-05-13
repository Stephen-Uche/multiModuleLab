package org.example.provider;

import org.example.service.Calculator;
import org.example.service.annotation.Calculation;

import java.util.Scanner;

@Calculation("Multiplication")
public class MultiplicationCalculator implements Calculator {
    public MultiplicationCalculator() {
        System.out.println("""
                ==============
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number ");
        Integer numb1 = scanner.nextInt();
        System.out.println("Enter second number ");
        Integer numb2 = scanner.nextInt();
        Integer result = numb1 * numb2;
        System.out.println("Result = "+ result);
        System.out.println("""
                ---------------------
                """);
    }

    @Override
    public Integer calculateNumbers(Integer a, Integer b) {
        return a * b;
    }
}
