package com.dvm.service;

import com.dvm.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getAllPerson();
    Person getPersonById(long personId);
    void deletePerson(long personId);
}
