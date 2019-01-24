package com.project.batch.jobs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import com.example.springBatch.model.Person;

@Component
public class JobCompletionNotificationListener  extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final CassandraTemplate cassandraTemplate;

    @Autowired
    public JobCompletionNotificationListener(final CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public void afterJob(final JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! NewSchemaJob is finished, Time to verify the results");

            log.info("Checking if items added..");

            long nrEntities = cassandraTemplate.count(Person.class);
            log.info("Number of records in Person table is " + nrEntities);

        }
    }

}