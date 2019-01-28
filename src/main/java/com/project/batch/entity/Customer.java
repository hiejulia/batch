package com.project.batch.entity;


import lombok.Data;

@Data
public class Customer {

    // Customer : id, firstname, lastname, address, account, tax id

    private long id = -1l;

    private String firstName;

    private String lastName;

    private Address address;

    private Account account;

    private String taxId;
}