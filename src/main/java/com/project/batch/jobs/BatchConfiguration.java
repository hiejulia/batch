//package com.project.batch.jobs;
//
//
//import javax.sql.DataSource;
//
//import com.project.batch.config.CassandraConfig;
//import com.project.batch.jobs.writes.MovieCassandraBatchItemWriter;
//import com.project.batch.jobs.writes.PersonCassandraBatchItemWriter;
//import com.project.batch.model.MovieDetails;
//import com.project.batch.model.Person;
//import com.project.batch.model.PersonDTO;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.core.io.ResourceLoader;
//
//
//
//@Configuration
//@EnableBatchProcessing
//@Import(CassandraConfig.class)
//@ComponentScan(basePackages = "com.project.batch")
//public class BatchConfiguration {
//
//    final int batchSize = 10;
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private ResourceLoader resourceLoader;
//    // Job builder factory - Step buider - Resource builder
//
//    // tag::readerwriterprocessor[]
//
//
//    // Read data
//    @Bean
//    public FlatFileItemReader<PersonDTO> reader() {
//        return new FlatFileItemReaderBuilder<PersonDTO>()
//                .name("personItemReader")
//                .resource(resourceLoader.getResource("classpath:sample_persons.csv"))
//                .delimited()
//                .delimiter(",") // split by ,
//                .names(new String[]{"firstName", "lastName"}) // name : first name - last bame
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<PersonDTO>() {{
//                    setTargetType(PersonDTO.class);
//                }})
//                .build();
//    }
//
//    @Bean
//    public ItemReader<MovieDetails>  mergeCSVFilesReader(){
//        return new MovieMergeCSVFileReader(resourceLoader);
//    }
//
//    /**
//     * Processor
//     * @return PersonItemProcessor
//     */
//    @Bean
//    public PersonItemProcessor processor() {
//        return new PersonItemProcessor();
//    }
//
//    @Bean
//    public ItemWriter<MovieDetails> movieWriter(){
//        return new MovieCassandraBatchItemWriter();
//    }
//
//    @Bean
//    public Job mergeAndImportMovieRelatedCSV(JobCompletionNotificationListener listener, @Qualifier("mergeCSVMovieStep1")Step step) {
//        return jobBuilderFactory.get("mergeMovieCSVFiles")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .start(step)
//                .build();
//    }
//
//
//    // Merge CSV Movie step 1
//    @Bean
//    public Step mergeCSVMovieStep1() {
//        return stepBuilderFactory.get("movieStep")
//                .<MovieDetails,MovieDetails> chunk(batchSize)
//                .reader(mergeCSVFilesReader())
//                .writer(movieWriter())
//                .build();
//    }
//
//
//
//    @Bean
//    public ItemWriter<Person> writer(DataSource dataSource) {
//        return new PersonCassandraBatchItemWriter<Person>(Person.class);
//    }
//    // end::readerwriterprocessor[]
//
//    // tag::jobstep[]
//
//    /**
//     * Import User job
//     * @param listener
//     * @param step1
//     * @return
//     */
//    @Bean
//    public Job importUserJob(JobCompletionNotificationListener listener, @Qualifier("step1") Step step1) {
//        return jobBuilderFactory.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .start(step1)
//                .build();
//    }
//
//    /**
//     * Step 1
//     * @param writer
//     * @return
//     */
//    @Bean
//    public Step step1(ItemWriter<Person> writer) {
//        return stepBuilderFactory.get("step1")
//                .<PersonDTO, Person> chunk(batchSize) // chunk: size
//                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .build();
//    }
//    // end::jobstep[]
//
//
//    // cuc ki kho chiu
//
//
//}