package com.example.bankoflykhvar.service.impl;

import com.example.bankoflykhvar.model.Account;
import com.example.bankoflykhvar.model.Transaction;
import com.example.bankoflykhvar.repository.TransactionRepository;
import com.example.bankoflykhvar.service.TransactionService;
import exception.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Account accountTo, Account accountFrom, double amount) {
        if (amount <= 0 || accountTo == null || accountFrom == null) {
            throw new RuntimeException("wrong amount or accounts!");
        }
        accountTo.setBalance(accountTo.getBalance() + amount);
        accountFrom.setBalance(accountFrom.getBalance() - amount);
        Transaction transaction = new Transaction();
        transaction.setAccountFrom(accountFrom);
        transaction.setAccountTo(accountTo);
        transaction.setAmount(amount);
        transaction.setType(Transaction.Type.INCOMING);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.getAllByAccount(pageable, account)
                .orElseThrow(() -> new EntityNotFoundException("Can't got transactions by account "
                        + account.getAccountNumber()));
    }
}
