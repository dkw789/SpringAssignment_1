package com.example.mydemo.service;


import com.example.mydemo.MydemoApplication;
import com.example.mydemo.exception.PersonNotFoundException;
import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public abstract class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    private RabbitTemplate rabbitTemplate;



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

    @Override
    public void sendPersonMessage(String id) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("id", id);
        log.info("Sending the index request through queue message");
        rabbitTemplate.convertAndSend(MydemoApplication.MY_MESSAGE_QUEUE, actionmap);
    }
}
