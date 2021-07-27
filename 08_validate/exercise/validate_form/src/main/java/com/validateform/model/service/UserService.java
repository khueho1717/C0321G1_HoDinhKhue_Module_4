package com.validateform.model.service;

import com.validateform.model.entity.User;
import com.validateform.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {
    void save(User user);
}
