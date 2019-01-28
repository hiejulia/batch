package com.project.batch.dao;


import com.project.batch.entity.Customer;

public interface CustomerDao {

    // Find customer by tax id
    Customer findCustomerByTaxId(String taxId);


    // Save customer
    void saveCustomer(Customer customer);
}