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
     * @param personDTO
     * @return Person
     * @throws Exception
     */
    @Override
    public Person process(PersonDTO personDTO) throws Exception {

        // Convert to upper case
        final String firstName = personDTO.getFirstname().toUpperCase();

        final String lastName = personDTO.getLastname().toUpperCase();
        // New Person(PersonPrimaryKey) - chuyen sang nghe rock - day la nguoi nhu the nao nhi - no van binh thuong nhe

        final Person transformedPerson = new Person(new PersonPrimaryKey(firstName, lastName));

        return transformedPerson;

    }



}