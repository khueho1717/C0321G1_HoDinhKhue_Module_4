package com.example.case_study_module4.model.service.service_service;

import com.example.case_study_module4.model.entity.ServiceType;
import com.example.case_study_module4.model.repository.service_repository.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(int id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(int id) {
        serviceTypeRepository.deleteById(id);
    }
}
