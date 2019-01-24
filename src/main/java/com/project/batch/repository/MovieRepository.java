package com.project.batch.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.springBatch.model.MovieDetails;

public interface MovieRepository extends CassandraRepository<MovieDetails,Long> {

}