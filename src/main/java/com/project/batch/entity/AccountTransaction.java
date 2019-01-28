package com.project.batch.entity;

import lombok.Data;

import java.math.BigDecimal;




@Data
public class AccountTransaction extends Transaction{


    // Octavirum

    private String accountNumber;

    private PricingTier tier;

    private BigDecimal fee;

    private long quantity;

    private BigDecimal price;

    // Account transaction : accountNumber, tier, fee, quantity, price

}
