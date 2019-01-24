package com.project.batch.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.springBatch.model.Person;
import com.example.springBatch.model.PersonPrimaryKey;

public interface PersonRepository extends CassandraRepository<Person,PersonPrimaryKey>{



}