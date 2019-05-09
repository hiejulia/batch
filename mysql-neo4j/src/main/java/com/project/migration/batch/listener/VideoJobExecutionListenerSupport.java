package com.project.migration.batch.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;



@Component
public class VideoJobExecutionListenerSupport extends JobExecutionListenerSupport {


    private static final Logger log = LoggerFactory.getLogger(VideoJobExecutionListenerSupport.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        super.beforeJob(jobExecution);
        log.info("------BEFORE JOB-----");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("-----VIDEO JOB FINNISHED-----");
        }
    }
}
