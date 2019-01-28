package com.project.batch.dao;


import com.project.batch.entity.Ticker;
import com.project.batch.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;



public interface TickerDao {

    // Find ticker by
    Ticker findTickerBySymbol(String symbol);

    void saveTicker(Ticker ticker);


    List<String> getTickersPaged(int page, int pageSize);


    // Get total value for customer
    BigDecimal getTotalValueForCustomer(long id);


    // Get stocks for customer - id
    List<Transaction> getStocksForCustomer(long id);




}