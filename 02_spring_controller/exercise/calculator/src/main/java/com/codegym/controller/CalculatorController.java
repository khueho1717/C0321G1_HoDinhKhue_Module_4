package com.codegym.controller;

import com.codegym.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String showCalculator() {
        return "index";
    }

    @GetMapping("/addition")
    public String getCondiment(@RequestParam(name = "action") String action, @RequestParam(name = "firstNum", defaultValue = "0") int firstNum, @RequestParam(name = "lastNum", defaultValue = "0") int lastNum, Model model) {
        String message = "yeu cau nhap so vao";
        if (lastNum == 0 && firstNum == 0) {
            model.addAttribute("message2", message);
            model.addAttribute("message1", message);
        } else if (lastNum == 0) {
            model.addAttribute("message2", message);
            model.addAttribute("firstNum", firstNum);

        } else if (firstNum == 0) {
            model.addAttribute("message1", message);
            model.addAttribute("lastNum", lastNum);

        } else {

            switch (action) {
                case "add":
                    double result = calculatorService.getAdd(firstNum, lastNum);
                    model.addAttribute("firstNum", firstNum);
                    model.addAttribute("lastNum", lastNum);
                    model.addAttribute("result", result);
                    break;
                case "sub":
                    double result2 = calculatorService.getSub(firstNum, lastNum);
                    model.addAttribute("firstNum", firstNum);
                    model.addAttribute("lastNum", lastNum);
                    model.addAttribute("result", result2);
                    break;
                case "mul":
                    double result3 = calculatorService.getMul(firstNum, lastNum);
                    model.addAttribute("firstNum", firstNum);
                    model.addAttribute("lastNum", lastNum);
                    model.addAttribute("result", result3);
                    break;
                case "div":
                    double result4 = calculatorService.getDiv(firstNum, lastNum);
                    model.addAttribute("firstNum", firstNum);
                    model.addAttribute("lastNum", lastNum);
                    model.addAttribute("result", result4);
                    break;
            }


        }
        return "index";
    }

}
