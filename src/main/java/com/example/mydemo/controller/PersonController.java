package com.example.mydemo.controller;

import com.example.mydemo.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mydemo.repository.PersonRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

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

    @RequestMapping(value="person", method = RequestMethod.GET)
    public List<Person> list() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public Person create(@RequestBody Person person){
        return personRepository.save(person);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public Optional<Person> get(@PathVariable Long id){
        return personRepository.findById(id);

    }

    
//    @RequestMapping(value = "person/{id}", method = RequestMethod.PUT)
//     public Person update(@PathVariable Long id, @RequestBody Person person){
//        Person existingperson = personRepository.findById(id);
//        BeanUtils.copyProperties(person, existingperson);
//        return personRepository.save(existingperson);
//    }

//    @RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
//    public Person delete(@PathVariable Long id){
//        Optional<Person> person= personRepository.findById(id);
//        personRepository.delete(person);
//        return person;
//    }
}