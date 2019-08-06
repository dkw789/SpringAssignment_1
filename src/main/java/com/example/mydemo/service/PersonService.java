package com.example.mydemo.service;

import com.example.mydemo.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> listPersons();

    Person findPerson(long id);

    Person saveOrUpdate(Person person);

    void delete(Long id);

    void sendPersonMessage(String id);

}

