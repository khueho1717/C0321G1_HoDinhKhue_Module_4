package com.example.case_study_module4.controller;

import com.example.case_study_module4.dto.CustomerDto;
import com.example.case_study_module4.dto.EmployeeDto;
import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.entity.Employee;
import com.example.case_study_module4.model.repository.employee_repository.IEmployeeRepository;
import com.example.case_study_module4.model.service.employee_service.IDivisionService;
import com.example.case_study_module4.model.service.employee_service.IEducationDegreeService;
import com.example.case_study_module4.model.service.employee_service.IEmployeeService;
import com.example.case_study_module4.model.service.employee_service.IPositionService;
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

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    IPositionService positionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IEmployeeService employeeService;

    @GetMapping
    public String listEmployee(@RequestParam(value = "search", required = false) String search,
                               @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Employee> employees;
        if (search != null) {
            employees=employeeService.findEmployees(search, pageable);
            model.addAttribute("search", search);
        } else {
            employees = employeeService.findAll(pageable);
        }
        model.addAttribute("employees", employees);
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.findAll());
        return "/employee/list";
    }

    @GetMapping("/create-employee")
    public String showFormCreateEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.findAll());
        return "/employee/create";
    }

    @PostMapping("/create-employee")
    public String saveBlog(@Validated @ModelAttribute(name = "employee") EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employeeService.save(employee);
            model.addAttribute("employee", new EmployeeDto());
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("educationDegree", educationDegreeService.findAll());
            model.addAttribute("message", "Employee create successfully");
            return "/employee/create";
        }else {
            model.addAttribute("employee", employeeDto);
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("educationDegree", educationDegreeService.findAll());
            model.addAttribute("messageFails", "Employee create failure");

            return "/employee/create";
        }
    }

    @GetMapping("/delete-employee")
    public String deleteEmloyee(@RequestParam int id) {
        employeeService.remove(id);
        return "redirect:/employees";
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee.get());
            modelAndView.addObject("position", positionService.findAll());
            modelAndView.addObject("division", divisionService.findAll());
            modelAndView.addObject("educationDegree", educationDegreeService.findAll());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-employee")
    public String updateEmployee(@Validated @ModelAttribute(name = "employee") EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
       if (!bindingResult.hasErrors()){
           Employee employee=new Employee();
           BeanUtils.copyProperties(employeeDto,employee);
           employeeService.save(employee);
           model.addAttribute("employee", employee);
           model.addAttribute("position", positionService.findAll());
           model.addAttribute("division", divisionService.findAll());
           model.addAttribute("educationDegree", educationDegreeService.findAll());
           model.addAttribute("message", "Employee update successfully");
           return "/employee/edit";
       }else {
           model.addAttribute("employee", employeeDto);
           model.addAttribute("position", positionService.findAll());
           model.addAttribute("division", divisionService.findAll());
           model.addAttribute("educationDegree", educationDegreeService.findAll());
           model.addAttribute("messageFails", "Employee update failure");
           return "/employee/edit";
       }
    }

    @GetMapping("/view-employee/{id}")
    public ModelAndView showBlog(@PathVariable int id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/employee/view");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error");
            return modelAndView;
        }
    }
}
