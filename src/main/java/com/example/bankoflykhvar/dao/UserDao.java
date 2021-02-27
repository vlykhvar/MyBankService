package com.example.bankoflykhvar.dao;

import com.example.bankoflykhvar.model.User;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findById(Long id);

    void update(User user);

    Optional<User> findByPhoneNumber(String phoneNumber);

    boolean removeUser(Long id);

}
