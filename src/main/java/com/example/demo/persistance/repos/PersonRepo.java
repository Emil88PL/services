package com.example.demo.persistance.repos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.rest.PersonDTO;

@Repository
public interface PersonRepo extends JpaRepository<PersonDTO, Long> {


    @Entity
    public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
   private int age;

   public Person(){
    super();
   }

public Person(long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}
}
}
