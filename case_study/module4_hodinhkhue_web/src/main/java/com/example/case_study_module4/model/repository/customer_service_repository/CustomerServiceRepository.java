package com.example.case_study_module4.model.repository.customer_service_repository;

import com.example.case_study_module4.dto.CustomerServiceDto;
import com.example.case_study_module4.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceRepository extends PagingAndSortingRepository<Customer, Integer> {
//    @Query(value = "select customer.customer_id as customerId, customer.customer_name as customerName, customer.customer_email as customerEmail ," +
//            " customer.customer_address as customerAddress, contract.contract_id as contractId," +
//            " contract.contract_total_money as contractTotalMoney," +
//            " attach_service.attach_service_name as attachServiceName, attach_service.attach_service_cost as attachServiceCost" +
//            " from customer " +
//            "right join contract on customer.customer_id = contract.customer_id " +
//            "left join contact_detail on contract.contract_id = contact_detail.contract_id " +
//            "left join attach_service on contact_detail.attach_service_id = attach_service.attach_service_id", nativeQuery = true)

    @Query(value="select customer.customer_id as customerId, customer.customer_name as customerName, customer.customer_email as customerEmail ," +
            " customer.customer_address as customerAddress, contract.contract_id as contractId," +
            " contract.contract_total_money as contractTotalMoney," +
            " attach_service.attach_service_name as attachServiceName, attach_service.attach_service_cost as attachServiceCost" +
            " from `customer` " +
            "right join contract on `customer`.customer_id = contract.customer_id " +
            "left join contact_detail on contract.contract_id = contact_detail.contract_id " +
            "left join attach_service on contact_detail.attach_service_id = attach_service.attach_service_id",nativeQuery = true)
    Page<CustomerServiceDto> findCustomerService(Pageable pageable);
}
