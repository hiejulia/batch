package com.project.batch.entity;


import lombok.Data;

@Data
public class AccountTransactionQuantity {


    private String accountNumber;

    private long transactionCount;

    private PricingTier tier;

    // Octavirum cuc ki co dien


}
