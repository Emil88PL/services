package com.example.services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private List<Person> people = new ArrayList<>();

    public Person addPerson(Person person) {
        // Add new Person
        this.people.add(person);
        // Return last added Person from List
        return this.people.get(this.people.size() - 1);
    }

    public List<Person> getAllPeople() {
        // Return the whole List
        return this.people;
    }

    public Person updatePerson(int id, Person person) {
        // Remove existing Person with matching 'id'
        this.people.remove(id);
        // Add new Person in its place
        this.people.add(id, person);
        // Return updated Person from List
        return this.people.get(id);
    }

    public Person removePerson(int id) {
        // Remove Person and return it
        return this.people.remove(id);
    }
}
