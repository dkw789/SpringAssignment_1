package com.example.mydemo.service;


import com.example.mydemo.exception.PersonNotFoundException;
import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> listPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPerson(long id) {
        Optional<Person> optionalApplication;
        optionalApplication = personRepository.findById(id);

        if (optionalApplication.isPresent())
            return optionalApplication.get();
        else
            throw new PersonNotFoundException("Application Not Found");
    }
}
