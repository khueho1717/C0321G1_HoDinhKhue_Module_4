package com.example.case_study_module4.model.repository.customer_repository;

import com.example.case_study_module4.model.entity.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType,Integer> {
}
