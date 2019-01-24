package com.project.batch.jobs;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;

public class CassandraBatchItemReader<Person> implements ItemReader<Person> {


    private static final Logger log = LoggerFactory.getLogger(CassandraBatchItemReader.class);

    @Autowired
    private CassandraOperations cassandraOperations;

    private final Class<Person> aClass;

    private int index = 0;

    public CassandraBatchItemReader(final Class<Person> aClass) {
        this.aClass = aClass;
    }

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	       /* final List<Person> companies = cassandraOperations.

	        if (index < companies.size()) {
	            final Company company = companies.get(index);
	            index++;
	            return company;
	        }*/
        log.debug("Read operations is performing, the object size is  {}");

        // Read the file - csv file





        return null;
    }

}
