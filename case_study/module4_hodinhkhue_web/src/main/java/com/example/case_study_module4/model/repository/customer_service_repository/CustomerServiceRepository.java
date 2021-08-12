package com.example.case_study_module4.model.repository.customer_service_repository;

import com.example.case_study_module4.dto.CustomerServiceDto;
import com.example.case_study_module4.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceRepository extends PagingAndSortingRepository<Customer, Integer> {

    @Query(value="select customer.customer_id as customerId, customer.customer_name as customerName, customer.customer_email as customerEmail ," +
            " customer.customer_address as customerAddress, contract.contract_id as contractId," +
            " contract.contract_total_money as contractTotalMoney," +
            " attach_service.attach_service_name as attachServiceName, attach_service.attach_service_cost as attachServiceCost" +
            " from `customer` " +
            "            join contract on `customer`.customer_id = contract.customer_id " +
            "            join service on contract.service_id = service.service_id " +
            "            join contact_detail on contract.contract_id = contact_detail.contract_id " +
            "            join attach_service on contact_detail.attach_service_id = attach_service.attach_service_id " +
            "            group by customer.customer_id",nativeQuery = true)
    Page<CustomerServiceDto> findCustomerService(Pageable pageable);

    @Query(value="select customer.customer_id as customerId, customer.customer_name as customerName, customer.customer_email as customerEmail ,\" +\n" +
            "            customer.customer_address as customerAddress, contract.contract_id as contractId,\" +\n" +
            "            sum(service.service_cost + contact_detail.quantity * attach_service.attach_service_cost) as contractTotalMoney,\" +\n" +
            "            attach_service.attach_service_name as attachServiceName, attach_service.attach_service_cost as attachServiceCost\" +\n" +
            "            from `customer` " +
            "                       join contract on `customer`.customer_id = contract.customer_id " +
            "                       join service on contract.service_id = service.service_id " +
            "                       join contact_detail on contract.contract_id = contact_detail.contract_id " +
            "                       join attach_service on contact_detail.attach_service_id = attach_service.attach_service_id " +
            "                      group by contract.contract_id "+
            "where customer.customer_name like %:search%" +
            " or attach_service.attach_service_name like %:search%" +
            " or customer.customer_address like %:search%",nativeQuery=true)
    Page<CustomerServiceDto> findCustomerUserService(@Param("search") String search, Pageable pageable);

}
