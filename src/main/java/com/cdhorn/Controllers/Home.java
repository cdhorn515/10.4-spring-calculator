package com.cdhorn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    private int total;
    private String totalAsString;
    private int operandOne;
    private int operandTwo;

    @RequestMapping("/")
    public String index(@RequestParam(value = "number1", required = false) String number1,
                        @RequestParam(value = "number2", required = false) String number2,
                        @RequestParam(value = "operator", required = false) String operator,
                        ModelMap model) {
        try {
        operandOne = Integer.parseInt(number1);
        operandTwo = Integer.parseInt(number2);

        System.out.println(number1);
        System.out.println(number2);
        System.out.println(operator);

        calculate(operandOne, operandTwo, operator);

        model.addAttribute("calculatedTotal", totalAsString);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        return "index";
    }


    public String calculate(int operandOne, int operandTwo, String operator) {

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
        totalAsString = String.format("%d", total);
        return totalAsString;
    }
}
