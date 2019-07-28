package com.example.mydemo.controller;

import com.example.mydemo.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonStub {
	private static Map<Long, Person> persona = new HashMap<Long, Person>();
	private static Long idIndex = 3L;

	//populate initial persona
	static {
		Person a = new Person(1L, "Sunil", "Kari", "1050 cresent ave", "416-345-4882", "sunil.kari@loblaws.ca", "Architech");
		persona.put(1L, a);
		Person b = new Person(2L, "john", "doe", "7855 Island village St", "416-468-1254", "john.doe@loblaws.ca", "Software developer");
		persona.put(2L, b);
		Person c = new Person(3L, "Yongala", "Asani", "426 rue des Longaniers","416-786-1586", "Yongala.Asani@loblaws.ca", "junior Software developer");
		persona.put(3L, c);
	}

	public static List<Person> list() {
		return new ArrayList<Person>(persona.values());
	}

	public static Person create(Person person1) {
		idIndex += idIndex;
		person1.setId(idIndex);
		persona.put(idIndex, person1);
		return person1;
	}

	public static Person get(Long id) {
		return persona.get(id);
	}

	public static Person update(Long id, Person person1) {
		persona.put(id, person1);
		return person1;
	}

	public static Person delete(Long id) {
		return persona.remove(id);
	}
}
