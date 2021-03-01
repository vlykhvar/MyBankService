package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.model.Account;
import com.example.bankoflykhvar.model.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction save(Account accountTo, Account accountFrom, double amount);

    List<Transaction> getAllByAccount(int page, int size, Account account);
}
