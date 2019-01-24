package com.project.batch.model;


import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PersonPrimaryKey {

    @PrimaryKeyColumn(name = "firstName", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String firstName;


    @PrimaryKeyColumn(name = "lastName", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonPrimaryKey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

// ta thich con nho nay roi day - a du nghe rock nay - dep ghe ha - co 2 lum dong tien
