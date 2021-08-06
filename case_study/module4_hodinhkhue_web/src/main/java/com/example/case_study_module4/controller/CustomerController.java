package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.service.customer_service.CustomerService;
import com.example.case_study_module4.model.service.customer_service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping
    public String listCustomer(@RequestParam(value = "search",required = false) String search,
                               @PageableDefault(value = 4) Pageable pageable, Model model){
        Page<Customer> customers;
        if (search!=null){
            customers=customerService.findCustomers(search,pageable);
            model.addAttribute("search",search);
        }else {
            customers=customerService.findAll(pageable);
        }
        model.addAttribute("customers",customers);
        model.addAttribute("customerType",customerTypeService.findAll());
        return "/customer/list";
    }

    @GetMapping("/create-customer")
    public String showFormCreateCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerType",customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create-customer")
    public String saveBlog(@ModelAttribute("customer") Customer customer,Model model) {
        customerService.save(customer);
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerType",customerTypeService.findAll());
        model.addAttribute("message", "Customer create successfully");
        return "/customer/create";
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customerType",customerTypeService.findAll());
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customerType",customerTypeService.findAll());
        modelAndView.addObject("customer", customerService.findById(customer.getCustomerId()));
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
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
