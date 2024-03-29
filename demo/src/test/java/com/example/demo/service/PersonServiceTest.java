package com.example.demo.service;

import com.example.demo.domain.Block;
import com.example.demo.domain.Person;
import com.example.demo.repository.BlockRepository;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

        result.forEach(System.out::println);
    }
    private void givenPeople() {
        givenPerson("Martin",10,"A");
        givenPerson("David",9,"B");
        givenPerson("Daniel",8,"O");
        givenPerson("Peter",11,"AB");

    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age,bloodType));
    }

    private void givenBlocks() {
        giveBlock("Martin");
    }

    private void giveBlock(String name) {
        blockRepository.save(new Block(name));
    }


}