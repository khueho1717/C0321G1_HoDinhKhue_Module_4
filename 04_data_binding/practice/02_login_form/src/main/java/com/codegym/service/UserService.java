package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;

public interface UserService {
    public User checkLogin(Login login);
}
