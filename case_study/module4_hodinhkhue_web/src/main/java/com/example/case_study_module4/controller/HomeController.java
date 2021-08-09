package com.example.case_study_module4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String showHome(){
        return "/home/homePage";
    }

    @GetMapping("/login")
    public String loginPage() {

        return "/login/login";
    }


}
