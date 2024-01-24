package com.health.service;

import com.health.dao.UserDao;
import com.health.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}
