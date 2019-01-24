package com.project.batch.model;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


// Table : Person - to cassandra database
@Table("person")
@Data
public class Person {

    @PrimaryKey
    private PersonPrimaryKey person;


}
