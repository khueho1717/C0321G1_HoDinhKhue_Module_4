package com.example.case_study_module4.model.repository.sercurity_repository;



import com.example.case_study_module4.model.entity.AppUser;
import com.example.case_study_module4.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
