package com.example.exam_module4.model.repository;

import com.example.exam_module4.model.entity.Customer;
import com.example.exam_module4.model.entity.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
