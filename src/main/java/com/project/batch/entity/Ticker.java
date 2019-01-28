package com.project.batch.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Ticker {

    // Ticker : id, ticker, price

    private long id;

    private String ticker;

    private BigDecimal price;


}
