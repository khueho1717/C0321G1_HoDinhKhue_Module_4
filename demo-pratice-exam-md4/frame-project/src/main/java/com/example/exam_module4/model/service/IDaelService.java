package com.example.exam_module4.model.service;

import com.example.exam_module4.model.entity.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IDaelService extends GeneralService<Deal> {
    Page<Deal> findAll(Pageable pageable);
    Page<Deal> findDeal( String search, Pageable pageable);
}
