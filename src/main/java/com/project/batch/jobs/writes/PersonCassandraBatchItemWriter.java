package com.project.batch.jobs.writes;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springBatch.model.Person;

import com.example.springBatch.service.PersonService;

public class PersonCassandraBatchItemWriter<Person> implements ItemWriter<com.example.springBatch.model.Person>, InitializingBean {

    protected static final Log logger = LogFactory.getLog(PersonCassandraBatchItemWriter.class);
    private final Class<Person> aClass;
    @Autowired
    private PersonService personService;
    @Override
    public void afterPropertiesSet() throws Exception { }

    public PersonCassandraBatchItemWriter(final Class<Person> aClass) {
        this.aClass = aClass;
    }

    @Override
    public void write(final List<? extends com.example.springBatch.model.Person> items) throws Exception {
        logger.debug("Write operations is performing, the size is {}" + items.size());
        if (!items.isEmpty()) {
            logger.info("Inserting in a batch performing...");
            for (com.example.springBatch.model.Person entity : items) {
                personService.saveEntity(entity);
            }

        }



    }

}

