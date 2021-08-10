package com.example.case_study_module4.controller;

import com.example.case_study_module4.dto.CustomerServiceDto;
import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.service.customer_service_service.ICustomerServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer-services")
public class CustomerServiceController {

    @Autowired
    ICustomerServiceService customerServiceService;

    @GetMapping
    public String listCustomerServices(
            @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<CustomerServiceDto> customers;
        customers = customerServiceService.findCustomerService(pageable);
        model.addAttribute("customers", customers);
        return "/customer_service/list";
    }


}
