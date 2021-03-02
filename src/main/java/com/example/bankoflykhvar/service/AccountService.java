package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.model.Account;
import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    Account add(Account account);

    BigDecimal getBalance(String accountNumber);

    List<Account> getAllUserAccountsByPhoneNumber(String phoneNumber);

    boolean blockingAccount(Account account);
}
