package com.example.case_study_module4.model.service.employee_service;

import com.example.case_study_module4.model.entity.Division;
import com.example.case_study_module4.model.repository.employee_repository.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService implements IDivisionService{

    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}
