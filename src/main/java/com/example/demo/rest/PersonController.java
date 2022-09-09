package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rest.PersonDTO;
import com.example.demo.services.PersonService;


@RestController
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public PersonDTO addPerson(@RequestBody PersonDTO person) {
        return this.service.addPerson(person);
    }

    @GetMapping("/getAll")
    public List<PersonDTO> getAllPeople() {
        return this.service.getAllPeople();
    }

    @PutMapping("/update")
    public PersonDTO updatePerson(@PathParam("id") Long id, @RequestBody PersonDTO person) {
        return this.service.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removePerson(@PathVariable Long id) {
        return this.service.removePerson(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }

}