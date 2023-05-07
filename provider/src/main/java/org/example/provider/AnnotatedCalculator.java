package org.example.provider;

import org.example.service.annotation.Calculation;

@Calculation("Add")
public class AnnotatedCalculator {
    public Integer add(){

        return 25 + 5;

    }
}
