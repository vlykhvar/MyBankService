package com.example.bankoflykhvar.service.impl;

import com.example.bankoflykhvar.model.Account;
import com.example.bankoflykhvar.model.Transaction;
import com.example.bankoflykhvar.repository.TransactionRepository;
import com.example.bankoflykhvar.service.TransactionService;
import exception.EntityNotFoundException;
import java.time.LocalDateTime;
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
        Transaction transactionOutcoming = new Transaction();
        transactionOutcoming.setAccountFrom(accountFrom);
        transactionOutcoming.setAccountTo(accountTo);
        transactionOutcoming.setAmount(amount);
        transactionOutcoming.setDate(LocalDateTime.now());
        transactionOutcoming.setType(Transaction.Type.OUTCOMING);
        transactionRepository.save(transactionOutcoming);
        accountFrom.setBalance(accountFrom.getBalance() - amount);
        Transaction transactionIncoming = new Transaction();
        transactionIncoming.setAccountFrom(accountFrom);
        transactionIncoming.setAccountTo(accountTo);
        transactionIncoming.setAmount(amount);
        transactionIncoming.setDate(LocalDateTime.now());
        transactionOutcoming.setType(Transaction.Type.INCOMING);
        transactionRepository.save(transactionIncoming);
        accountTo.setBalance(accountTo.getBalance() + amount);
        return transactionOutcoming;
    }

    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.getAllByAccount(pageable, account)
                .orElseThrow(() -> new EntityNotFoundException("Can't got transactions by account "
                        + account.getAccountNumber()));
    }
}
