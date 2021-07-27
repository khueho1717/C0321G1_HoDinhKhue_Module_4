package com.validateform.controller;

import com.validateform.dto.UserDto;
import com.validateform.model.entity.User;
import com.validateform.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }
    @PostMapping(value = "/")
    public String result(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult , Model model) {

        if (bindingResult.hasFieldErrors()) {
            return "/index";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            model.addAttribute("user", user);
            return "/result";
        }
    }

}
