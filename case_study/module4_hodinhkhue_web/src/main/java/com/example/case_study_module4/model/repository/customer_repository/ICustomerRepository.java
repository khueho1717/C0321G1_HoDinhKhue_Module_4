package com.example.case_study_module4.model.repository.customer_repository;

import com.example.case_study_module4.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    @Query(value = "select *  " +
            "from customer  join customer_type  on customer.type_customer_id = customer_type.id " +
            "where customer.customer_name like %:search% or customer_type.type_name like %:search% " +
            "or customer.customer_address like %:search%",nativeQuery=true)
    Page<Customer> findCustomers(@Param("search") String search, Pageable pageable);
}
