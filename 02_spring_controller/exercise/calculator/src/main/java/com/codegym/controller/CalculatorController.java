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
    public String getCondiment(@RequestParam(name = "calculation") String calculation,
                               @RequestParam(name = "firstNum",defaultValue = "0.0",required = false) float firstNum,
                               @RequestParam(name = "lastNum",defaultValue = "0.0", required = false) float lastNum, Model model) throws Exception {

        String message = "yeu cau nhap so vao";
        if (lastNum == 0.0 && firstNum == 0.0) {
            model.addAttribute("message2", message);
            model.addAttribute("message1", message);
            return "index";
        } else if (lastNum == 0 && firstNum != 0) {
            model.addAttribute("message2", "khong chia duoc cho khong");
            model.addAttribute("firstNum", firstNum);
            return "index";
        } else if (lastNum == 0.0) {
            model.addAttribute("message2", message);
            model.addAttribute("firstNum", firstNum);
            return "index";
        } else if (firstNum == 0.0) {
            model.addAttribute("message1", message);
            model.addAttribute("lastNum", lastNum);
            return "index";
        } else {
            float result = calculatorService.calculator(firstNum, lastNum, calculation);
            model.addAttribute("firstNum", firstNum);
            model.addAttribute("lastNum", lastNum);
            model.addAttribute("result", result);
            return "index";
        }
    }

}
