package com.example.exam_module4.model.service;

import com.example.exam_module4.model.entity.Deal;
import com.example.exam_module4.model.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DealService implements IDaelService {

    @Autowired
    DealRepository dealRepository;

    @Override
    public Page<Deal> findAll(Pageable pageable) {
        return dealRepository.findAll(pageable);
    }

    @Override
    public Page<Deal> findDeal(String search, Pageable pageable) {
        return dealRepository.findDeal(search, pageable);
    }

    @Override
    public Iterable<Deal> findAll() {
        return dealRepository.findAll();
    }

    @Override
    public Optional<Deal> findById(int id) {
        return dealRepository.findById(id);
    }

    @Override
    public void save(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public void remove(int id) {
        dealRepository.deleteById(id);
    }
}
