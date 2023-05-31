package org.example.provider;

import annotation.Calculation;
import org.example.service.Calculator;

import java.util.Scanner;
@Calculation("Addition")
public class AdditionCalculator implements Calculator {
    @Override
    public Integer calculateNumber() {
        return add();
    }
    public static int add() {

        System.out.println("""
                ==============
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number ");
        int numb1 = scanner.nextInt();
        System.out.println("Enter second number ");
        int numb2 = scanner.nextInt();
        System.out.println("Result = " );
        return numb1 + numb2;
    }


}
