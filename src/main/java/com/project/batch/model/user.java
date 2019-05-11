package com.project.batch.model;




import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;


@Entity
@Data
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

