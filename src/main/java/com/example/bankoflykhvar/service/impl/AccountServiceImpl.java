package com.example.bankoflykhvar.service.impl;

import com.example.bankoflykhvar.model.Account;
import com.example.bankoflykhvar.repository.AccountRepository;
import com.example.bankoflykhvar.service.AccountService;
import exception.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account add(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Double getBalance(String accountNumber) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account was not find by number "
                        + accountNumber));
        return account.getBalance();
    }

    @Override
    public List<Account> getAllUserAccountsByPhoneNumber(String phoneNumber) {
        return accountRepository.findAccountsByPhoneNumber(phoneNumber).orElseThrow(()
                -> new EntityNotFoundException("Account was not find by phone number: "
                + phoneNumber));
    }

    @Override
    public boolean blockingAccount(Account account) {
        account.setActive(false);
        add(account);
        return true;
    }
}
