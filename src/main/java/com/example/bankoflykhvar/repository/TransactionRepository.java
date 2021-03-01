package com.example.bankoflykhvar.repository;

import com.example.bankoflykhvar.model.Account;
import com.example.bankoflykhvar.model.Transaction;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t join fetch t.accountFrom"
            + " join fetch t.accountTo WHERE t.accountFrom = ?2")
    Optional<List<Transaction>> getAllByAccount(Pageable pageable, Account account);
}
