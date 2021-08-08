package com.example.case_study_module4.controller;

import com.example.case_study_module4.dto.CustomerDto;
import com.example.case_study_module4.dto.ServiceDto;
import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.entity.Service;
import com.example.case_study_module4.model.service.service_service.IRentTypeService;
import com.example.case_study_module4.model.service.service_service.IServiceService;
import com.example.case_study_module4.model.service.service_service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("services")
public class ServiceController {

    @Autowired
    IServiceService serviceService;

    @Autowired
    IServiceTypeService serviceTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/create-service")
    public String showFormCreateService(Model model){
        model.addAttribute("service",new ServiceDto());
        model.addAttribute("serviceTypes",serviceTypeService.findAll());
        model.addAttribute("rentTypes",rentTypeService.findAll());
        return "/service/create";
    }

    @PostMapping("/create-service")
    public String saveBlog(@Validated @ModelAttribute(name = "service") ServiceDto service, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Service service1=new Service();
            BeanUtils.copyProperties(service,service1);
            serviceService.save(service1);
            model.addAttribute("service", new ServiceDto());
            model.addAttribute("serviceTypes", serviceTypeService.findAll());
            model.addAttribute("rentTypes", rentTypeService.findAll());
            model.addAttribute("message", "Service create successfully");
            return "/service/create";
        }else {
            model.addAttribute("serviceTypes", serviceTypeService.findAll());
            model.addAttribute("rentTypes", rentTypeService.findAll());
            model.addAttribute("messageFails", "Service create failure");
            return "/service/create";
        }
    }
}
