package com.project.migration.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
@ComponentScan(value = "com.project.migration.batch")
@Import(value = { DatabaseConfiguration.class, KafkaProducerConfig.class })
public class BatchConfig {




    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private VideoAssetWrapperItemProcessor videoAssetWrapperItemProcessor;

    @Autowired
    private GraphVideoItemWriter graphVideoItemWriter;

    @Autowired
    private VideoAssetWrapperItemReadListener videoAssetWrapperItemReadListener;

    @Autowired
    private VideoAssetWrapperSkipListener videoAssetWrapperSkipListener;

    @Autowired
    private GraphVideoItemWriteListener graphVideoItemWriteListener;

    @Autowired
    private VideoJobExecutionListenerSupport videoJobExecutionListenerSupport;

    @Bean
    public BatchConfigurer configurer(EntityManagerFactory entityManagerFactory ){
        return new CustomBatchConfigurer();
    }

    @Bean(destroyMethod = "")
    public ItemReader<VideoAssetWrapper> videoAssetWrapperItemReader() {
        JpaPagingItemReader jpaPagingItemReader = new JpaPagingItemReader();
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
        jpaPagingItemReader.setQueryString("select e from VideoAssetWrapper e");
        jpaPagingItemReader.setMaxItemCount(179);
        jpaPagingItemReader.setPageSize(1000);
        return jpaPagingItemReader;
    }

    @Bean
    public Job importUserJob(JobBuilderFactory jobs) {
        return jobs.get("importVideo")
                .incrementer(new RunIdIncrementer())
                .listener(videoJobExecutionListenerSupport)
                .flow(videoAssetWrapperStep()).end()
                .build();
    }

    @Bean
    public Step videoAssetWrapperStep() {
        return steps.get("videoAssetWrapperToGraphVideo")
                .<VideoAssetWrapper, Video>chunk(10)
                .reader(videoAssetWrapperItemReader())
                .listener(videoAssetWrapperItemReadListener)
                .processor(videoAssetWrapperItemProcessor)
                .writer(graphVideoItemWriter)
                .listener(graphVideoItemWriteListener)
                .faultTolerant().skipLimit(1).skip(ValidationException.class).listener(videoAssetWrapperSkipListener)
                .build();
    }
}
