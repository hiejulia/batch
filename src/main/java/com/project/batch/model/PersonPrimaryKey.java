package com.project.batch.model;


import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PersonPrimaryKey {

    @PrimaryKeyColumn(name = "firstName", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String firstName;
    @PrimaryKeyColumn(name = "lastName", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String lastName;


    public PersonPrimaryKey(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
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


}