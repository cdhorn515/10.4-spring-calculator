package com.cdhorn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    private double operandOne;
    private double operandTwo;

    Calculations calculations = new Calculations();

    @RequestMapping("/")
    public String index(@RequestParam(value = "number1", required = false) String number1,
                        @RequestParam(value = "number2", required = false) String number2,
                        @RequestParam(value = "operator", required = false) String operator,
                        ModelMap model) {
        try {
        operandOne = Double.parseDouble(number1);
        operandTwo = Double.parseDouble(number2);

        System.out.println(number1);
        System.out.println(number2);
        System.out.println(operator);
        String calculate = calculations.calculate(operandOne, operandTwo, operator);
        String total = calculations.getTotalAsString();
        model.addAttribute("calculatedTotal", number1 + " " + operator + " " +  number2 + " = " + total);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return "index";
    }


}
