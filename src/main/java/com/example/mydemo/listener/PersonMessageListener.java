package com.example.mydemo.listener;

import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class PersonMessageListener {

    private static final Logger log = LogManager.getLogger(PersonMessageListener.class);
    private PersonRepository personRepository;

    public PersonMessageListener(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * This method is invoked whenever any new message is put in the queue.
     */
    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            person.setMessageReceived(true);
        }
        if (person != null) {
            person.setMessageCount(person.getMessageCount() + 1);
        }

        personRepository.save(person);
        log.info("Message processed...");
    }
}
