package com.dvm.controller;

import com.dvm.model.Person;
import com.dvm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity <List<Person>> getAllProduct() {
        return ResponseEntity.ok().body(personService.getAllPerson());
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createProduct(@RequestBody Person person) {
        return ResponseEntity.ok().body(this.personService.createPerson(person));
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updateProduct(@PathVariable long id, @RequestBody Person person) {
        person.setId(id);
        return ResponseEntity.ok().body(this.personService.updatePerson(person));
    }

    @DeleteMapping("/person/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.personService.deletePerson(id);
        return HttpStatus.OK;
    }
}
