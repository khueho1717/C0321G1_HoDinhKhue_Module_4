package com.example.case_study_module4.model.repository.sercurity_repository;

import com.example.case_study_module4.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUserName(String username);

}
