package com.example.case_study_module4.model.repository.contact_repository;

import com.example.case_study_module4.model.entity.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepossitorry extends JpaRepository<AttachService,Integer> {
}