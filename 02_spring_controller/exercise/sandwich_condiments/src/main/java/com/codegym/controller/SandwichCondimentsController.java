package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {
    @GetMapping("/")
    public String showCondiment() {
        return "index";
    }

    @GetMapping("/condiment")
    public String getCondiment(@RequestParam(value = "condiments",required = false) String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "index";
    }

}
