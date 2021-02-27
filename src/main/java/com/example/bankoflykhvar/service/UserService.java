package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.model.User;

public interface UserService {
    User add(User user);

    User findById(Long id);

    void update(User user);

    User findByPhoneNumber(String phoneNumber);

    boolean removeUser(Long id);
}
