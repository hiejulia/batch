package com.project.batch.reader;

import com.project.batch.entity.Account;
import com.project.batch.service.transaction.AccountService;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;


public class AccountReader implements ItemStreamReader<Account> {

    private ListItemReader<Account> accountReader;


    @Autowired
    private AccountService accountService;
    // ListItemReader- Account

    //


    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account read() throws Exception, UnexpectedInputException,
            ParseException {
        return accountReader.read();
    }

    public void open(ExecutionContext executionContext) throws ItemStreamException {
        accountReader = new ListItemReader<Account>(accountService.getAccounts());
    }

    public void close() throws ItemStreamException {
    }

    public void update(ExecutionContext arg0) throws ItemStreamException {
    }
}