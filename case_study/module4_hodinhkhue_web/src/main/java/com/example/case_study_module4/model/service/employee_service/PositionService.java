package com.example.case_study_module4.model.service.employee_service;

import com.example.case_study_module4.model.entity.Position;
import com.example.case_study_module4.model.repository.employee_repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
