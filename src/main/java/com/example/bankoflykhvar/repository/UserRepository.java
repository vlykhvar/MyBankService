package com.example.bankoflykhvar.repository;

import com.example.bankoflykhvar.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @Query("SELECT u from User u join fetch u.roles where u.id = ?1")
    Optional<User> findById(Long id);

    @Query("SELECT u from User u join fetch u.roles where u.phoneNumber = ?1")
    Optional<User> findByPhoneNumber(String phoneNumber);
}
