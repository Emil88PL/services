package com.example.services.services;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController<Person> {

    private List<Person> people = new ArrayList<>();

    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }

       // Create
       @PostMapping("/create")
       public boolean addPerson(@RequestBody Person person) {
           return this.people.add(person);
       }

        // READ
        @GetMapping("/getAll")
        public List<Person> getAll() {
            return this.people;
        }

        //Update
        @PutMapping("/update")
        public Person updatePerson(@PathParam("id") int id, @RequestBody Person person) {

            // Remove existing Person with matching 'id'
            this.people.remove(id);

            // Add new Person in its place
            this.people.add(id, person);
            
            // Return updated Person from List
            return this.people.get(id);
        }

        //Delete
        @DeleteMapping("/delete/{id}")
        public Person removePerson(@PathVariable int id) {
            // Remove Person and return it
            return this.people.remove(id);
        }





}