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
    public String getCondiment(@RequestParam(name = "lettuce", defaultValue = "") String lettuce, @RequestParam(name = "mustard", defaultValue = "") String mustard, @RequestParam(name = "tomato", defaultValue = "") String tomato, @RequestParam(name = "sprouts", defaultValue = "") String sprouts, Model model) {
        model.addAttribute("lettuce", lettuce);
        model.addAttribute("mustard", mustard);
        model.addAttribute("tomato", tomato);
        model.addAttribute("sprouts", sprouts);

        return "index";
    }

}
