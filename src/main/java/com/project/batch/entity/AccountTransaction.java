package com.project.batch.entity;

import java.math.BigDecimal;

public class AccountTransaction extends Transaction{



    private String accountNumber;

    private PricingTier tier;

    private BigDecimal fee;

    private long quantity;

    private BigDecimal price;
}
