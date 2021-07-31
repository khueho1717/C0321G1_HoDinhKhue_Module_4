package com.manager_phone.model.service;

import com.manager_phone.model.entity.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<SmartPhone> findAll();

    Page<SmartPhone> findAll(Pageable pageable);

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
