package com.project.batch.model;


import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
@Data
public class PersonPrimaryKey {

    @PrimaryKeyColumn(name = "firstName", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String firstName;


    @PrimaryKeyColumn(name = "lastName", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String lastName;





}