package com.project.batch.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Account extends Transaction{

    private long id = -1;

    private String accountNumber;

    private Customer cust;

    private BigDecimal cashBalance;

    private PricingTier tier;

    private List<Transaction> transactions;


    // Account :id, accountNumber, cust, cashBalance, tier, transaction


}
