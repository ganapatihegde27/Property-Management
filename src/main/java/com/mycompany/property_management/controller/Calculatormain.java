package com.mycompany.property_management.controller;

public class Calculatormain {
    public static void main(String[] args) {
        CalculatorController cc = new CalculatorController();
        Double result = cc.add(10.0, 20.1);
        System.out.println(result);
    }
}
