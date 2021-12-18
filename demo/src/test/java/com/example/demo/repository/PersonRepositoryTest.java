package com.example.demo.repository;

import com.example.demo.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Test
    void crud(){
        Person person = new Person();
        person.setName("Martin");
        person.setAge(10);
        personRepository.save(person);
        System.out.println(personRepository.findAll());
    }
}