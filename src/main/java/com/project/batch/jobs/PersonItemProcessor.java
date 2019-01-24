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
        // Validation
        // Convert name to uppercase

        String firstName = personDTO.getFirstName().toUpperCase();

        String lastName = personDTO.getLastName().toUpperCase();


        // transformedPerson :
        final Person transformedPerson = new Person(new PersonPrimaryKey(firstName, lastName));

        // return transformed person
        return transformedPerson;
    }



}