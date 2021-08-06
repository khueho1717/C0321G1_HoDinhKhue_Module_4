package com.example.case_study_module4.model.service.customer_service;

import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService extends GeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findCustomers(String search, Pageable pageable);
}
