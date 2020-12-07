package ru.xorsiphus.controllers.tests;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController
{
    @GetMapping
    public String calculate(@RequestParam(name="firstParam", required=false, defaultValue="0") int firstParam,
                            @RequestParam(name="secondParam", required=false, defaultValue="0") int secondParam,
                            @RequestParam(name="operation", required=false, defaultValue="+") String operation,
                            Model model)
    {
        model.addAttribute("firstParam", firstParam);
        model.addAttribute("secondParam", secondParam);

        switch (operation)
        {
            case "sum" -> {
                model.addAttribute("operation", "plus");
                model.addAttribute("answer", firstParam + secondParam);
            }
            case "-" -> {
                model.addAttribute("operation", "subtraction");
                model.addAttribute("answer", firstParam - secondParam);
            }
            case "*" -> {
                model.addAttribute("operation", "multiplication");
                model.addAttribute("answer", firstParam * secondParam);
            }
            case "/" -> {
                model.addAttribute("operation", "division");
                if (secondParam == 0) secondParam = 1;
                model.addAttribute("answer", firstParam / (double) secondParam);
            }
            default -> {
                model.addAttribute("operation", "invalid operation");
                model.addAttribute("answer", 0);
            }
        }

        return "calculator";
    }
}
