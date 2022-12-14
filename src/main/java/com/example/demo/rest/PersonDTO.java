package com.example.demo.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
   private int age;

//    public Person(){
//     super();
//    }

public PersonDTO() {
    super();
}

public PersonDTO(long id, String name, int age) {
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
