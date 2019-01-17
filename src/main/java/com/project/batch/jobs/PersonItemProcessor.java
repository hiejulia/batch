package com.project.batch.jobs;

import com.project.batch.model.Person;
import com.project.batch.model.PersonDTO;
import com.project.batch.model.PersonPrimaryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;



public class PersonItemProcessor implements ItemProcessor<PersonDTO,Person>{

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    /**
     *
     * @param person
     * @return Person
     * @throws Exception
     */
    @Override
    public Person process(final PersonDTO person) throws Exception {

        // Convert name to uppercase
        final String firstName = person.getFirstName().toUpperCase();

        final String lastName = person.getLastName().toUpperCase();


        final Person transformedPerson = new Person(new PersonPrimaryKey(firstName, lastName));


        return transformedPerson;
    }



}