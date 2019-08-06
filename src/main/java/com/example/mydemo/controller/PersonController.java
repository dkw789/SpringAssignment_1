package com.example.mydemo.controller;

import com.example.mydemo.exception.PersonNotFoundException;
import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import com.example.mydemo.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/")
public class PersonController {

    private static final Logger log = LogManager.getLogger(PersonController.class);

    private final PersonRepository personRepository;
    private final PersonService personService;
    private Long id;
    private Person person;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

//    private Object person;
//    @ResponseBody
//    @GetMapping("/hello")
//    public String test() {
//        Person person = new Person();
//        person.setFirstName("First");
//        person.setLastName("Last");
//        personRepository.save(person);
//        return "hello";
//    }

    @GetMapping(value = "persons")
    public List<Person> mylist() {
        return PersonStub.list();
    }

    @GetMapping(value = "person")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> list = personService.listPersons();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }
//    public List<Person> list() {
//        return personRepository.findAll();
//    }


    @PostMapping(value = "person", consumes = "application/json;charset=UTF-8")
    public Person create(@RequestBody Person person){
        return personRepository.saveAndFlush(person);
    }

//    @RequestMapping(value = "persons", method = RequestMethod.POST , consumes = "application/json;charset=UTF-8" )
//    public Person createmany(@RequestBody Person manyperson){
//        for (int i=0; i < manyperson.size(); i++){
//            Person p = personRepository.getOne(id);
//        }
//        return personRepository.saveAndFlush(person);
//    }

    @GetMapping(value = "person/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        try {
            return new ResponseEntity<Person>(personService.findPerson(id),
                    HttpStatus.OK);
        } catch (PersonNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
        }
        //        return personRepository.findById(id);

    }


    @PutMapping(value = "person/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {

        Person existingperson = personRepository.getOne(id);
        BeanUtils.copyProperties(person, existingperson);
        return personRepository.saveAndFlush(existingperson);
    }

    @DeleteMapping(value = "person/{id}")
    public void delete(@PathVariable Long id) {
        Person person = personRepository.getOne(id);
        personRepository.delete(person);
//        personRepository.deleteById(id);
    }

    @RequestMapping("/person/indexPerson/{id}")
    public String indexProduct(@PathVariable String id) {
        personService.sendPersonMessage(id);
        return "redirect:/person/" + id;
    }

}