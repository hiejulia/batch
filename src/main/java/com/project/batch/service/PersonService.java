package com.project.batch.service;


import java.util.List;


import com.project.batch.model.Person;
import com.project.batch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
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

    public void saveEntity(Person p) {
        personRepo.insert(p);
    }


    public List<Person> saveAll(List<Person> toSave){
        return personRepo.saveAll(toSave);
    }

}