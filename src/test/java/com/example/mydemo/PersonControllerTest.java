package com.example.mydemo;

import com.example.mydemo.controller.PersonController;
import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PersonControllerTest {
    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonRepository personRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public void setUp() {
//        mock = MockMvcBuilders.webAppContextSetup(we).build();

    }


    @Test
    public void testPersonGet() {
        Person p1 = new Person();
        p1.setId(1L);
        p1.setFirstName("first");
        p1.setLastName("last");
        when(personRepository.findById(1L)).thenReturn(Optional.of(p1));

        Optional<Person> p2;
        p2 = personController.get(1L);
//        verify(personRepository).getOne(1L);
        p2.ifPresent(person -> assertEquals(1L, person.getId().longValue()));
        p2.ifPresent(person -> assertThat(p2.get(), is(1L)));

    }

//    @Test
//    public void testPersonCreate() {
//        //        p1.setId(1L);
//        Person p1 = personController.create(new Person(1L, "Sunil", "Kari", "1050 cresent ave", "416-345-4882", "sunil.kari@loblaws.ca", "Architech"));
//        when(personRepository.findById(1L)).thenReturn(Optional.of(p1));
//        Optional<Person> p2 = personController.get(1L);
//        verify(personRepository).findById(1L);
//        p2.ifPresent(person -> assertEquals("Sunil", person.getFirstName()));
//    }


    @Test
    public void list() {

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}
