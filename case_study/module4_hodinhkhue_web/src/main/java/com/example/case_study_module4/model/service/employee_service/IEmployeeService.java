package com.example.case_study_module4.model.service.employee_service;

import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.entity.Employee;
import com.example.case_study_module4.model.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService extends GeneralService<Employee> {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findEmployees(String search, Pageable pageable);

}
