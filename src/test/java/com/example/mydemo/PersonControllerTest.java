package com.example.mydemo;

import com.example.mydemo.controller.PersonController;
import com.example.mydemo.model.Person;
import com.example.mydemo.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
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

//    @Test
//    public void testPersonGet() {
//        Person p1 = new Person();
//        p1.setId(1L);
//        when(personRepository.findOne(1L)).thenReturn(p1);
//        Person p2 = pc.get(1L);
//        verify(personRepository).findOne(1L);
//        assertEquals(1L, p2.getId().longValue());
//
//    }

}
