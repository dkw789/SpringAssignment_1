package com.example.mydemo;

import com.example.mydemo.controller.PersonController;
import com.example.mydemo.repository.PersonRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
//        when(personRepository.getOne(1L)).thenReturn(p1);
//        Optional<Person> p2 = pc.get(1L);
//        verify(personRepository).getOne(1L);
//        assertEquals(1L, p2.get().getId().longValue());
//    }

}
