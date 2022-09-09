package com.example.services.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistance.repos.PersonRepo.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

}
