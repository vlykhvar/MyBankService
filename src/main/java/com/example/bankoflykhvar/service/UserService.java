package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.model.User;

public interface UserService {
    User save(User user);

    User findById(Long id);

    User findByPhoneNumber(String phoneNumber);

    void remove(Long id);
}
