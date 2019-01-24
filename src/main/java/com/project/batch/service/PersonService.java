package com.project.batch.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    public PersonRepository getPersonRepo() {
        return personRepo;
    }

    public void setPersonRepo(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    public Person saveEntity(Person p) {
        return personRepo.save(p);
    }

    public List<Person> saveAll(List<Person> toSave){
        return personRepo.saveAll(toSave);
    }

}