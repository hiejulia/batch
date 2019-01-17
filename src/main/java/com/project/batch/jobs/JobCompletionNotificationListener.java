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
    // Job completion notification listener
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    // Cassandra template
    private final CassandraTemplate cassandraTemplate;

    @Autowired
    public JobCompletionNotificationListener(final CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    // trong nhi 1 nha soan nhac hoan hao ay - may nguoi nay dep ma -
    @Override
    public void afterJob(final JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

            log.info("!!! NewSchemaJob is finished, Time to verify the results");
            long nrEntities = cassandraTemplate.count(Person.class);
            log.info("Number of records in Person table is " + nrEntities);
            log.info("---- JOB CASSANDRA IS DONE-----");

        }
    }
//set up cassandra database
    // qua nhieu thang tan - a du hap dan nguoi khac gioi day ban -
// day la kieu nguoi co the gioi rieng ay - the gioi noi tam phong phu

// nhung nguoi nghe dream theater - la nhung nguoi cuc ki song noi tam - the thoi



// nghe dream theater -

    /// nghe dream theater -

    // nghe dong progressive metal luonb a

    // day la kieu nguoi cam xu c=
    // nghe dream theater luon a - no dang code - no khong muon ai stop no het







    // nghe dream theater luon

}

