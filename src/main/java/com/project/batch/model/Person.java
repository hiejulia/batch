package com.project.batch.model;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


// Table : Person - to cassandra database
@Table("person")
public class Person {

    @PrimaryKey
    private PersonPrimaryKey person;


    public PersonPrimaryKey getPerson() {
        return person;
    }

    public void setPerson(PersonPrimaryKey person) {
        this.person = person;
    }

    public Person(PersonPrimaryKey person) {
        this.person = person;
    }
}
