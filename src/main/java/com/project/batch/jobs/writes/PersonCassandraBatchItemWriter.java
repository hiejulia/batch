package com.project.batch.jobs.writes;

import java.util.List;


import com.project.batch.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonCassandraBatchItemWriter<Person> implements ItemWriter<Person>, InitializingBean {

    protected static final Log logger = LogFactory.getLog(PersonCassandraBatchItemWriter.class);

    private final Class<Person> aClass;

    // Autowired: PersonService
    @Autowired
    private PersonService personService;

    @Override
    public void afterPropertiesSet() throws Exception { }

    public PersonCassandraBatchItemWriter(final Class<Person> aClass) {
        this.aClass = aClass;
    }

    @Override
    public void write(final List<? extends Person> items) throws Exception {

        logger.debug("Write operations is performing, the size is {}" + items.size());

        if (!items.isEmpty()) {

            logger.info("Inserting in a batch performing...");

            for (Person entity : items) {

                logger.debug("Save person {}"+entity);

//                personService.saveEntity(entity);
                // save to cassandra database



            }

        }



    }


}

