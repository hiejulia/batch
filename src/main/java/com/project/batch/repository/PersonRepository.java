package com.project.batch.repository;


import com.project.batch.model.Person;
import com.project.batch.model.PersonPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PersonRepository extends CassandraRepository<Person,PersonPrimaryKey>{



}