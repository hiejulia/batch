package com.project.batch.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


// Save to table : Movie - cassandra
@Table("movie")
@Data
public class MovieDetails {

    // Primary key : movieId
    @PrimaryKey
    private Long movieId;

    @Column
    private String title;

    @Column("directorName")
    private String director;



}