package com.example.case_study_module4.model.repository.service_repository;

import com.example.case_study_module4.model.entity.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends PagingAndSortingRepository<ServiceType,Integer> {
}
