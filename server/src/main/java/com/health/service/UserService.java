package com.health.service;

import com.health.dao.UserDao;
import com.health.exceptionhandling.RegistrationException;
import com.health.model.RegisterUserDTO;
import com.health.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void registerUser(RegisterUserDTO newUser) {
        if (!userDao.create(newUser.getUsername(), newUser.getPassword())) {
            throw new RegistrationException("User registration failed. Unable to create user in the database.");
        }
    }


}
