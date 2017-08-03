package com.cdhorn.Controllers;

import com.cdhorn.Interfaces.OperationRepository;
import com.cdhorn.Models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
public class Home {
    private double operandOne;
    private double operandTwo;
    Operation operation = new Operation();
    Calculations calculations = new Calculations();

    @Autowired
    OperationRepository operationRepo;

    @RequestMapping("/")
    public String index(@RequestParam(value = "number1", required = false) String number1,
                        @RequestParam(value = "number2", required = false) String number2,
                        @RequestParam(value = "operator", required = false) String operator,
                        @RequestParam(value = "calculatoruser", required = false) String calculatoruser,
                        ModelMap model) {

        try {
        operandOne = Double.parseDouble(number1);
        operandTwo = Double.parseDouble(number2);

            System.out.println(number1);
            System.out.println(operator);
            System.out.println(number2);

        calculations.calculate(operandOne, operandTwo, operator);
        String total = calculations.getTotalAsString();
        model.addAttribute("total", total);
        model.addAttribute("calculatedTotal", number1 + " " + operator + " " +  number2 + " = " + total);

        Operation operation = new Operation(operandOne, operator, operandTwo, total , calculatoruser);

        operationRepo.save(operation);


        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return "redirect:/{calculatoruser}";
    }

    @RequestMapping("/{calculatoruser}")
    public String showOperations(@RequestBody("calculatoruser") String calculatoruser, Model model) {
        Query query = EntityManager.createNamedQuery("findByCalculatorUser", List<Operation> calculatoruser);
//        Query q = em.createNamedQuery("selectAuthorValue");
//        List<AuthorValue> authors = q.getResultList();
        Operation.findByCalculatorUser(calculatoruser);
//List<Email> findByEmailIdInAndPincodeIn(List<String> emails, List<String> pinCodes);

        return "userOperations";
    }

}
