package com.example.mydemo.controller;

import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class PersonController {


    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
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

    @RequestMapping(value = "persons", method = RequestMethod.GET)
    public List<Person> mylist() {
        return PersonStub.list();
    }

    @RequestMapping(value="person", method = RequestMethod.GET)
    public List<Person> list() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "person", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
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

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public Optional<Person> get(@PathVariable Long id){
        return personRepository.findById(id);

    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.PUT)
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        Person existingperson = personRepository.getOne(id);
        BeanUtils.copyProperties(person, existingperson);
        return personRepository.saveAndFlush(existingperson);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Person person = personRepository.getOne(id);
        personRepository.delete(person);
//        personRepository.deleteById(id);
    }
}