package com.project.batch.repository;

import com.project.batch.model.MovieDetails;
import org.springframework.data.cassandra.repository.CassandraRepository;



// Repository
public interface MovieRepository extends CassandraRepository<MovieDetails,Long> {
    // Movie Repository

}

// hot go cua lang lap trinh -

// tinh con nho nay giong con trai vcl