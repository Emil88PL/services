package com.example.services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

   // private List<Person> people = new ArrayList<>();

    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }

}