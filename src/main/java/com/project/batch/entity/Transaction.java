package com.project.batch.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class Transaction {

    // Transaction : id, accountId,


    private long id;

    private long accountId;

    private String accountNumber;


    private String ticker;
    private long tickerId;
    private long quantity;
    private Date tradeTimestamp;
    private BigDecimal dollarAmount;
    private TransactionType type;

}
