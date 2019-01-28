package com.project.batch.dao;


import com.project.batch.entity.Account;

import java.util.List;



public interface AccountDao {

    // Find account by number
    Account findAccountByNumber(String accountNumber);

    // Save account
    void saveAccount(Account account);


    // Load accounts
    List<Account> loadAccounts();
}