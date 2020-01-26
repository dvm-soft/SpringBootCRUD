package com.dvm.service;

import com.dvm.exception.ResourceNotFoundException;
import com.dvm.model.Person;
import com.dvm.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return (Person) personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Optional<Person> personDb = this.personRepository.findById(person.getId());
        if(personDb.isPresent()) {
            Person personUpdate = personDb.get();
            personUpdate.setId(personUpdate.getId());
            personUpdate.setFirstName(personUpdate.getFirstName());
            personUpdate.setMidName(personUpdate.getMidName());
            personUpdate.setSecondName(personUpdate.getSecondName());
            personUpdate.setSex(personUpdate.getSex());
            personUpdate.setBirthday(personUpdate.getBirthday());
            personRepository.save(personUpdate);
            return personUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + person.getId());
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    @Override
    public Person getPersonById(long personId) {
        Optional<Person> personDb = this.personRepository.findById(personId);

        if (personDb.isPresent()) {
            return personDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + personId);
        }
    }

    @Override
    public void deletePerson(long personId) {
        Optional<Person> productDb = this.personRepository.findById(personId);

        if (productDb.isPresent()) {
            this.personRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + personId);
        }
    }
}
