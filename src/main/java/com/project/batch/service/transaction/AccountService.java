package com.project.batch.service.transaction;


import java.util.List;

import com.apress.springbatch.statement.domain.Account;

public interface AccountService {

    List<Account> getAccounts();
}