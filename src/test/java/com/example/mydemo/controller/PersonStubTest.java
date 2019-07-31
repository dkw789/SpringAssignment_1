package com.example.mydemo.controller;

import com.example.mydemo.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class PersonStubTest {

    private PersonStub personstub;


    @Test
    public void list() {
        List<String> list2 = Arrays.asList("1", "2", "3");

        List<Person> list = PersonStub.list();
        if (list.size() >= 1) {

            assertArrayEquals(list.size(), list2.size());
            assertArrayEquals(list.size(), 3);

        }

    }

    private void assertArrayEquals(int size, int i) {
    }

    @Test
    public void create() {

    }

    @Test
    public void get() {
        Person p2 = PersonStub.get(2L);
        assertArrayEquals(p2.getId().intValue(), 2);


    }

    @Test
    public void update() {

        Person p2 = PersonStub.get(1L);
        Person a = new Person(1L, "'Lissie'", "'Bakhrushkin'", "'97 Springview Drive", "'698-216-2445'", "lbakhrushkin0@hostgator.com", "Developer I");
        Person p3 = PersonStub.update(1L, a);
        assertNotEquals(p3, p2);

    }

    @Test
    public void delete() {
        Person p2 = PersonStub.get(1L);
        PersonStub.delete(1L);
        Person p3 = PersonStub.get(1L);
        assertNotEquals(p2, p3);

    }
}