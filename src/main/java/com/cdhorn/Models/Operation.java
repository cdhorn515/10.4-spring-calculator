package com.cdhorn.Models;


import javax.persistence.*;

@Entity
@Table(name= "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double operandOne;
    private double operandTwo;
    private String operator;
    private double limitDecimalTotal;

    @ManyToOne
    @JoinColumn(name = "calculatoruser_id")
    private CalculatorUser calculatorUsers;

    public Operation() {
    }

    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getLimitDecimalTotal() {
        return limitDecimalTotal;
    }

    public void setLimitDecimalTotal(double limitDecimalTotal) {
        this.limitDecimalTotal = limitDecimalTotal;
    }

    public CalculatorUser getCalculatorUsers() {
        return calculatorUsers;
    }

    public void setCalculatorUsers(CalculatorUser calculatorUsers) {
        this.calculatorUsers = calculatorUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
