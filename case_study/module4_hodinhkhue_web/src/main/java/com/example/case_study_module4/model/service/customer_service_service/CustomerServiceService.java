package com.example.case_study_module4.model.service.customer_service_service;

import com.example.case_study_module4.dto.CustomerServiceDto;
import com.example.case_study_module4.model.repository.customer_service_repository.CustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceService implements ICustomerServiceService {
    @Autowired
    CustomerServiceRepository customerServiceRepository;

    @Override
    public Page<CustomerServiceDto> findCustomerService(Pageable pageable) {
        return customerServiceRepository.findCustomerService(pageable);
    }
}
