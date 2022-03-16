package org.example.service;

import org.example.domain.Account;

import java.util.List;

public interface AccountService {
    public void save(Account account);
    public List<Account> findAll();
}
