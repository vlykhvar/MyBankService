package com.example.bankoflykhvar.dao;

import com.example.bankoflykhvar.model.User;

public interface UserDao extends Dao<User> {
    User findById(Long id);

    void update(User user);

    User findByPhoneNumber(String phoneNumber);

    boolean removeUser(Long id);

}
