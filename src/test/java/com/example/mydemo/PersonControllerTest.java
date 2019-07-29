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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class PersonControllerTest {
    @InjectMocks
    private PersonController pc;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPersonGet() {
        Person p1 = new Person();
        p1.setId(1L);
        p1.setFirstName("first");
        p1.setLastName("last");
        when(personRepository.getOne(1L)).thenReturn(p1);
        Optional<Person> p2 = pc.get(1L);
//        verify(personRepository).getOne(1L);
        p2.ifPresent(person -> assertEquals(1L, person.getId().longValue()));

//  below needs :
//  import static org.hamcrest.Matchers.*;
//        assertThat(p2.get(id), is(1L));

    }

    @Test
    public void testPersonCreate() {
        Person p1 = new Person();
        p1.setId(1L);
        p1.setFirstName("first");
        p1.setLastName("last");
        when(personRepository.getOne(1L)).thenReturn(p1);
        Optional<Person> p2 = pc.get(1L);
//        verify(personRepository).getOne(1L);
        p2.ifPresent(person -> assertEquals("first", person.getFirstName()));
    }

}
