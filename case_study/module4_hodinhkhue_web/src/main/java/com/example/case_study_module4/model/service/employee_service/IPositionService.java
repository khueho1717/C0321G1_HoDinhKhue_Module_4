package com.example.case_study_module4.model.service.employee_service;

import com.example.case_study_module4.model.entity.Position;

public interface IPositionService {
    Iterable<Position> findAll();
}
