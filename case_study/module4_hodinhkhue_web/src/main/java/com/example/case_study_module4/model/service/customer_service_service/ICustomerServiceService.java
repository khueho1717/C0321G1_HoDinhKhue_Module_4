package com.example.case_study_module4.model.service.customer_service_service;

import com.example.case_study_module4.dto.CustomerServiceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerServiceService {
    Page<CustomerServiceDto> findCustomerService(Pageable pageable);

}
