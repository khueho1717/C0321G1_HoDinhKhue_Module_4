package com.example.case_study_module4.model.service.service_service;

import com.example.case_study_module4.model.entity.RentType;
import com.example.case_study_module4.model.repository.service_repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(int id) {
        return rentTypeRepository.findById(id);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(int id) {
        rentTypeRepository.deleteById(id);
    }
}
