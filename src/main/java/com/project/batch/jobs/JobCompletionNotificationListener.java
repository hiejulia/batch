package com.project.batch.jobs;


import com.project.batch.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;



@Component
public class JobCompletionNotificationListener  extends JobExecutionListenerSupport {
    // JobCompletionNotificationListener

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final CassandraTemplate cassandraTemplate;

    @Autowired
    public JobCompletionNotificationListener(final CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }
    // CassandraTemplate

    // After job :
    @Override
    public void afterJob(final JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {


            long nrEntities = cassandraTemplate.count(Person.class);

            log.info("Number of records in Person table is " + nrEntities);

            // Long the number of person in the data file 

        }
    }



}