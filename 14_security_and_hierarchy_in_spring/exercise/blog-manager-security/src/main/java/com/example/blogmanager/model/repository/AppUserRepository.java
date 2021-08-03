package com.example.blogmanager.model.repository;

import com.example.blogmanager.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUserName(String username);

}
