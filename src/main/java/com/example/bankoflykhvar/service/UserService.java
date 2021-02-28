package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.model.User;

public interface UserService {
    User save(User user);

    User findById(Long id);

    User findByPhoneNumber(String phoneNumber);

    User update(User user);

    void remove(Long id);
}
