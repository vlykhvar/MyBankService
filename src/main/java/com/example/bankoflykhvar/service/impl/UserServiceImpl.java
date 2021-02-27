package com.example.bankoflykhvar.service.impl;

import com.example.bankoflykhvar.dao.UserDao;
import com.example.bankoflykhvar.model.User;
import com.example.bankoflykhvar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElseThrow();
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userDao.findByPhoneNumber(phoneNumber).orElseThrow();
    }

    @Override
    public boolean removeUser(Long id) {
        return userDao.removeUser(id);
    }
}
