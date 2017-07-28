package com.cdhorn.Controllers;


import java.text.DecimalFormat;

public class Calculations {

    private double total;
    private String totalAsString;
    DecimalFormat df = new DecimalFormat("#.##");

    public String getTotalAsString() {
        return totalAsString;
    }

    public Calculations() {
    }

    public String calculate(double operandOne, double operandTwo, String operator) {

        switch (operator) {
            case "+":
                total = operandOne + operandTwo;

                break;
            case "-":
                total = operandOne - operandTwo;
                break;
            case "*":
                total = operandOne * operandTwo;
                break;
            case "/":
                total = operandOne / operandTwo;
                break;
        }
        df.format(total);
        totalAsString = Double.toString(total);
        return totalAsString;
    }

    }


