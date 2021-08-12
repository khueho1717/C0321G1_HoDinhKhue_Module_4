package com.example.case_study_module4.controller;

import com.example.case_study_module4.dto.ContractDto;
import com.example.case_study_module4.dto.ServiceDto;
import com.example.case_study_module4.model.entity.Contract;
import com.example.case_study_module4.model.entity.Service;
import com.example.case_study_module4.model.service.contract_service.IContractService;
import com.example.case_study_module4.model.service.customer_service.ICustomerService;
import com.example.case_study_module4.model.service.employee_service.IEmployeeService;
import com.example.case_study_module4.model.service.service_service.IServiceService;
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
@RequestMapping("contracts")
public class ContractController {

    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IServiceService serviceService;
    @Autowired
    IContractService contractService;

    @GetMapping("/create-contract")
    public String showFormCreateContract(Model model){
        model.addAttribute("contract",new ContractDto());
        model.addAttribute("employees",employeeService.findAll());
        model.addAttribute("customers",customerService.findAll());
        model.addAttribute("services",serviceService.findAll());
        return "/contract/create";
    }

    @PostMapping("/create-contract")
    public String saveBlog(@Validated @ModelAttribute(name = "contract") ContractDto contractDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Contract contract=new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            contractService.totalMoney();
            contractService.save(contract);
            model.addAttribute("contract",new ContractDto());
            model.addAttribute("employees",employeeService.findAll());
            model.addAttribute("customers",customerService.findAll());
            model.addAttribute("services",serviceService.findAll());
            model.addAttribute("message", "Contract create successfully");
            return "/contract/create";
        }else {
            model.addAttribute("contract",contractDto);
            model.addAttribute("employees",employeeService.findAll());
            model.addAttribute("customers",customerService.findAll());
            model.addAttribute("services",serviceService.findAll());
            model.addAttribute("messageFails", "Contract create failure");
            return "/contract/create";
        }
    }


}
