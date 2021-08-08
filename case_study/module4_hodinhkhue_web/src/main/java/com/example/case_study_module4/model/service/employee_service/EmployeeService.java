package com.example.case_study_module4.model.service.employee_service;

import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.entity.Employee;
import com.example.case_study_module4.model.repository.employee_repository.IDivisionRepository;
import com.example.case_study_module4.model.repository.employee_repository.IEducationDegreeRepository;
import com.example.case_study_module4.model.repository.employee_repository.IEmployeeRepository;
import com.example.case_study_module4.model.repository.employee_repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findEmployees(String search, Pageable pageable) {
        return employeeRepository.findEmployees(search, pageable);
    }
}
