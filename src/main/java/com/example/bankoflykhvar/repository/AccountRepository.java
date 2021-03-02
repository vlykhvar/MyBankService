package com.example.bankoflykhvar.repository;

import com.example.bankoflykhvar.model.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a join fetch a.user WHERE a.accountNumber = ?1")
    Optional<Account> findAccountByAccountNumber(String accountNumber);

    @Query("SELECT a FROM Account a join fetch a.user WHERE a.user.phoneNumber = ?1")
    Optional<List<Account>> findAccountsByPhoneNumber(String phoneNumber);
}
