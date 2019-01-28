package com.project.batch.batch;


import com.project.batch.model.user;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserDbReader implements ItemReader<user> {



    @Value("${input.csv.file}")
    private Resource resource;


    @Bean
    public FlatFileItemReader<user> itemReader(){
        FlatFileItemReader<user> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(getLineMapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<user> getLineMapper() {
        DefaultLineMapper<user> userLineMapper = new DefaultLineMapper<user>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "department", "salary");
        BeanWrapperFieldSetMapper<user> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(user.class);
        userLineMapper.setLineTokenizer(lineTokenizer);
        userLineMapper.setFieldSetMapper(fieldSetMapper);
        return userLineMapper;
    }


    @Override
    public user read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}

