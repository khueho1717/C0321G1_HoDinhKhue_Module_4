package com.manager_phone.model.service;

import com.manager_phone.model.entity.SmartPhone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
