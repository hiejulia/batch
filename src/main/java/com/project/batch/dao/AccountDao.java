package com.project.batch.dao;


import java.util.List;



public interface AccountDao {

    Account findAccountByNumber(String accountNumber);

    void saveAccount(Account account);

    List<Account> loadAccounts();
}