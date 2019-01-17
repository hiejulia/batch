package com.project.batch.model;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("person")
@Data
public class Person {

    @PrimaryKey
    private PersonPrimaryKey person;



}