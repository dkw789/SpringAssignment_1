package com.example.mydemo.controller;

import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
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

        ResponseEntity<Person> p2;
        p2 = personController.get(1L);
        verify(personRepository).findById(1L);
        assertEquals(1L, p2.getBody().getId().longValue());
        assertThat(p2.getStatusCode(), is(200));

    }

//    @Test
//    public void testPersonCreate() {
//
//        Person p1 = new Person(4L, "'Lissie'", "'Bakhrushkin'", "'97 Springview Drive", "'698-216-2445'", "lbakhrushkin0@hostgator.com", "Developer I");
//        Person n = personController.create(@RequestBody Person p1);
//        assertEquals(n, p1);
//        when(personRepository.findById(1L)).thenReturn(Optional.of(p1));
//        Optional<Person> p2 = personController.get(1L);
//        verify(personRepository).findById(1L);
//        p2.ifPresent(person -> assertEquals("Sunil", person.getFirstName()));
//    }


//    @Test
//    public void list() {
//        List list = personController.list();
//        int size = list.size();
//        assertEquals(10, size);
////        assertThat(size, eq(10));
//
//    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}
