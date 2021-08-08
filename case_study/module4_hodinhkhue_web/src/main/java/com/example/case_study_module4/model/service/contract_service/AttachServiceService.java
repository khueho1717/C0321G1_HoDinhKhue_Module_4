package com.example.case_study_module4.model.service.contract_service;

import com.example.case_study_module4.model.entity.AttachService;
import com.example.case_study_module4.model.repository.contact_repository.IAttachServiceRepossitorry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    IAttachServiceRepossitorry attachServiceRepossitorry;

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepossitorry.findAll();
    }
}
