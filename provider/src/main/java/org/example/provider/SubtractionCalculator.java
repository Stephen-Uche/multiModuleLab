package org.example.provider;

import annotation.Calculation;
import org.example.service.Calculator;

import java.util.Scanner;

@Calculation("Subtraction")
public class SubtractionCalculator implements Calculator {


    @Override
    public Integer calculateNumber() {
        return Subtract();
    }

    public int Subtract() {
        System.out.println("""
                ===========
                """);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number ");
        Integer numb1 = scanner.nextInt();
        System.out.println("Enter second number ");
        Integer numb2 = scanner.nextInt();
        System.out.println("Result = " );

        return numb1 - numb2;
    }
}
