package com.example.demo.services;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.rest.PersonDTO;
import com.example.demo.persistance.repos.PersonRepo;

@Service
public class PersonService {

    private PersonRepo repo;

    private ModelMapper mapper;

    public PersonService(PersonRepo repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

    private PersonDTO mapToDTO(PersonDTO person) {
        return this.mapper.map(person, PersonDTO.class);
    }

    public PersonDTO addPerson(PersonDTO person) {
        PersonDTO saved =  this.repo.save(person);
        return this.mapToDTO(saved);
    }

    public List<PersonDTO> getAllPeople() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PersonDTO updatePerson(Long id, PersonDTO newPerson) {
        Optional<PersonDTO> existingOptional = this.repo.findById(id);
        PersonDTO existing = existingOptional.get();

        existing.setAge(newPerson.getAge());
        existing.setName(newPerson.getName());

        PersonDTO updated =  this.repo.save(existing);
        return this.mapToDTO(updated);
    }

    public boolean removePerson(Long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }

}