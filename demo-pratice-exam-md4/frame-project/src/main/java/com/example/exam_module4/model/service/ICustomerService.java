package com.example.exam_module4.model.service;

import com.example.exam_module4.model.entity.Customer;

public interface ICustomerService {
    Iterable<Customer> findAll();
}
