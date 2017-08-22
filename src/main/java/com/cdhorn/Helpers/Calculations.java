package com.cdhorn.Helpers;


import java.text.DecimalFormat;

public class Calculations {

    private double total;
    private String totalAsString;
    private double limitDecimalTotal;
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
        limitDecimalTotal = Double.parseDouble(df.format(total));
        totalAsString = Double.toString(limitDecimalTotal);
        return totalAsString;
    }

    public double getLimitDecimalTotal() {
        return limitDecimalTotal;
    }
}


