package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.model.Account;
import java.util.List;

public interface AccountService {
    Account add(Account account);

    Double getBalance(String accountNumber);

    List<Account> getAllUserAccountsByPhoneNumber(String phoneNumber);

    boolean blockingAccount(Account account);
}
