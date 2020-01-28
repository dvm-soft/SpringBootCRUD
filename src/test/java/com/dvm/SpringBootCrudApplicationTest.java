package com.dvm;

import com.dvm.exception.ResourceNotFoundException;
import com.dvm.model.Person;
import com.dvm.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringBootCrudApplicationTest {


    @Autowired
    private PersonService personService;

    Person person;

    @Test
    void contextLoads() {
    }

    @Test
    void getPerson() {
        person = personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        assertEquals(person.getId(), personService.getPersonById(person.getId()).getId());
    }

    @Test
    void addPerson() {
        int count = personService.getAllPerson().size();
        person = personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        assertEquals(person.getId(), personService.getPersonById(person.getId()).getId());
        assertEquals(count, personService.getAllPerson().size()-1);
    }

    @Test
    void updatePerson() {
        person = personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        person.setLastName("lastName2");
        personService.updatePerson(person);
        assertEquals(person.getLastName(), personService.getPersonById(person.getId()).getLastName());
    }

    @Test
    void deletePerson() {
        person = personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        int count = personService.getAllPerson().size();
        personService.deletePerson(person.getId());
        assertEquals(count, personService.getAllPerson().size() + 1);
        Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> {
            personService.deletePerson(person.getId());
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getListPersons() {
        int count = personService.getAllPerson().size();
        personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        personService.createPerson(new Person("firstName1", "midName1", "lastName1", true, LocalDate.now()));
        assertEquals(count + 4, personService.getAllPerson().size());
    }


}
