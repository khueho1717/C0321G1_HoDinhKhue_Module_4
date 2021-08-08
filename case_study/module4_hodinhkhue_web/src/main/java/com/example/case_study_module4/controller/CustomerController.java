package com.example.case_study_module4.controller;

import com.example.case_study_module4.dto.CustomerDto;
import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.service.customer_service.CustomerService;
import com.example.case_study_module4.model.service.customer_service.CustomerTypeService;
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
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping
    public String listCustomer(@RequestParam(value = "search", required = false) String search,
                               @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Customer> customers;
        if (search != null) {
            customers = customerService.findCustomers(search, pageable);
            model.addAttribute("search", search);
        } else {
            customers = customerService.findAll(pageable);
        }
        model.addAttribute("customers", customers);
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/list";
    }

    @GetMapping("/create-customer")
    public String showFormCreateCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create-customer")
    public String saveBlog(@Validated @ModelAttribute(name = "customer") CustomerDto customer, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Customer customer1=new Customer();
            BeanUtils.copyProperties(customer,customer1);
            customerService.save(customer1);
            model.addAttribute("customer", new CustomerDto());
            model.addAttribute("customerType", customerTypeService.findAll());
            model.addAttribute("message", "Customer create successfully");
            return "/customer/create";
        }else {
            model.addAttribute("customer", customer);
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/create";
        }
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customerType", customerTypeService.findAll());
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@Validated @ModelAttribute(name = "customer") CustomerDto customer, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Customer customer1=new Customer();
            BeanUtils.copyProperties(customer,customer1);
            customerService.save(customer1);
            model.addAttribute("customer", new CustomerDto());
            model.addAttribute("customerType", customerTypeService.findAll());
            model.addAttribute("message", "Customer create successfully");
            return "/customer/edit";
        }else {
            model.addAttribute("customer", customer);
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/edit";
        }
    }

    @GetMapping("/delete-customer")
    public String showDeleteForm(@RequestParam int id) {
        customerService.remove(id);
        return "redirect:/customers";
    }

    @GetMapping("/view-customer/{id}")
    public ModelAndView showBlog(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/view");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error");
            return modelAndView;
        }
    }

}
