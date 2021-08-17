package com.example.exam_module4.controller;

import com.example.exam_module4.model.dto.DealDto;
import com.example.exam_module4.model.entity.Deal;
import com.example.exam_module4.model.service.CustomerService;
import com.example.exam_module4.model.service.DealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deals")
public class DealController {

    @Autowired
    DealService dealService;
    @Autowired
    CustomerService customerService;

    @GetMapping
    public String listDeal(@RequestParam(value = "search", required = false) String search,
            @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Deal> deals;
        if (search != null) {
            deals = dealService.findDeal(search, pageable);
            model.addAttribute("search", search);
        } else {
            deals = dealService.findAll(pageable);
        }
        model.addAttribute("deals", deals);
        model.addAttribute("customers", customerService.findAll());
        return "/deal/list";
    }

    @GetMapping("/create-deal")
    public String showFormCreateCustomer(Model model) {
        model.addAttribute("deal", new DealDto());
        model.addAttribute("customers", customerService.findAll());
        return "/deal/create";
    }

    @PostMapping("/create-deal")
    public String saveBlog(@Validated @ModelAttribute(name = "deal") DealDto dealDto, BindingResult bindingResult, Model model) {
        new DealDto().validate(dealDto,bindingResult);
        if (!bindingResult.hasErrors()) {
            Deal deal = new Deal();
            BeanUtils.copyProperties(dealDto, deal);
            Iterable<Deal> deals=dealService.findAll();
            for (Deal deal1: deals){
                if (deal1.getDealCode().equals(deal.getDealCode())){
                    model.addAttribute("deal", dealDto);
                    model.addAttribute("customers", customerService.findAll());
                    model.addAttribute("messageCode","mã trùng");
                    model.addAttribute("messageFails", "Deal create failure");
                    return "/deal/create";
                }
            }
            dealService.save(deal);
            model.addAttribute("deal", new DealDto());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("message", "Deal create successfully");
            return "/deal/create";
        } else {
            model.addAttribute("deal", dealDto);
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("messageFails", "Deal create failure");
            return "/deal/create";
        }
    }

    @GetMapping("/delete-deal")
    public String showDeleteForm(@RequestParam int id) {
        dealService.remove(id);
        return "redirect:/deals";
    }
}
