package com.cdhorn.Models;


import javax.persistence.*;


@Table(name= "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double operandone;
    private double operandtwo;
    private String operator;
    private String total;

    private String calculatoruser;

    public Operation() {
    }

    public Operation(double operandone, String operator, double operandtwo, String total, String calculatoruser) {
        this.operandone = operandone;
        this.operandtwo = operandtwo;
        this.operator = operator;
        this.total = total;
        this.calculatoruser = calculatoruser;
    }

    public double getOperandone() {
        return operandone;
    }

    public void setOperandone(double operandone) {
        this.operandone = operandone;
    }

    public double getOperandtwo() {
        return operandtwo;
    }

    public void setOperandtwo(double operandTwo) {
        this.operandtwo = operandtwo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCalculatoruser() {
        return calculatoruser;
    }

    public void setCalculatoruser(String calculatoruser) {
        this.calculatoruser = calculatoruser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
