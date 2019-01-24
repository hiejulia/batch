package com.project.batch.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class user {

    @Id
    public Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEPT")
    private String department;

    @Column(name = "SALARY")
    private Integer salary;

    @Column(name = "DATE")
    private Date date;
}

