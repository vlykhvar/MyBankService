package com.example.bankoflykhvar.service.impl;

import com.example.bankoflykhvar.model.User;
import com.example.bankoflykhvar.repository.UserRepository;
import com.example.bankoflykhvar.service.UserService;
import exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Don't find user by id - " + id));
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(()
                -> new EntityNotFoundException("Don't find user by phoneNumber - " + phoneNumber));
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        if (newUser == null) {
            throw new EntityNotFoundException("Can't update " + user.toString());
        }
        return userRepository.save(user);

    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
