package com.example.case_study_module4.controller;

import com.example.case_study_module4.dto.ContractDetailDto;
import com.example.case_study_module4.dto.ContractDto;
import com.example.case_study_module4.model.entity.Contract;
import com.example.case_study_module4.model.entity.ContractDetail;
import com.example.case_study_module4.model.service.contract_service.IAttachServiceService;
import com.example.case_study_module4.model.service.contract_service.IContractDetailService;
import com.example.case_study_module4.model.service.contract_service.IContractService;
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
@RequestMapping("contract-details")
public class ContractDetailController {

    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachServiceService attachServiceService;

    @GetMapping("/create-contract-detail")
    public String showFormCreateContractDetail(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        model.addAttribute("contracts",contractService.findAll());
        model.addAttribute("attachServices",attachServiceService.findAll());
        return "/contract_detail/create";
    }

    @PostMapping("/create-contract-detail")
    public String saveBlog(@Validated @ModelAttribute(name = "contractDetailDto") ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            ContractDetail contractDetail=new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            contractDetailService.save(contractDetail);
            model.addAttribute("contractDetailDto",new ContractDetailDto());
            model.addAttribute("contracts",contractService.findAll());
            model.addAttribute("attachServices",attachServiceService.findAll());
            model.addAttribute("message", "Contract Detail create successfully");
            return "/contract_detail/create";
        }else {
            model.addAttribute("contractDetailDto",contractDetailDto);
            model.addAttribute("contracts",contractService.findAll());
            model.addAttribute("attachServices",attachServiceService.findAll());
            model.addAttribute("messageFails", "Contract DeTail create failure");
            return "/contract_detail/create";
        }
    }

}
