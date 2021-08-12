package com.example.case_study_module4.controller;

import com.example.case_study_module4.dto.CustomerServiceDto;
import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.service.contract_service.IAttachServiceService;
import com.example.case_study_module4.model.service.contract_service.IContractDetailService;
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
    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping
    public String listCustomerServices(@RequestParam(value = "search", required = false) String search,
            @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<CustomerServiceDto> customers;
        if (search != null){
            customers=customerServiceService.findCustomerUserService(search, pageable);
            model.addAttribute("search", search);
        }else {
            customers = customerServiceService.findCustomerService(pageable);
        }
        model.addAttribute("customers", customers);
        model.addAttribute("contractdetail",contractDetailService.findAll());
        return "/customer_service/list";
    }



}
