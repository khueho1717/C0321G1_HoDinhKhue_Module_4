package com.example.case_study_module4.model.service.service_service;

import com.example.case_study_module4.model.repository.service_repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public Iterable<com.example.case_study_module4.model.entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<com.example.case_study_module4.model.entity.Service> findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(com.example.case_study_module4.model.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(int id) {
        serviceRepository.deleteById(id);
    }
}
