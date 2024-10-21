package com.CleverCanines.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.CleverCanines.be.service.PersonService;
import com.CleverCanines.be.dto.output.Person;
import com.CleverCanines.be.enums.Role;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    
    // QueryMappings

    @QueryMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @QueryMapping
    public List<Person> getPersonsByRole(@Argument Role role) {
        return personService.getPersonsByRole(role);
    }

    @QueryMapping
    public Person getPerson(@Argument UUID id) {
        return personService.getPerson(id);
    }

    // MutationMappings

    @MutationMapping
    public Person addPerson(@Argument String username, @Argument String dogName, @Argument Role role) {
        Person person = new Person();
        person.setUsername(username);
        person.setDogName(dogName);
        person.setRole(role);
        return personService.addPerson(person);
    }

    @MutationMapping
    public Person updatePerson(@Argument UUID id, @Argument String username, @Argument String dogName, @Argument Role role) {
        Person person = personService.getPerson(id);
        person.setUsername(username);
        person.setDogName(dogName);
        person.setRole(role);
        return personService.updatePerson(person);
    }

    @MutationMapping
    public void deletePerson(@Argument UUID id) {
        personService.deletePerson(id);
    }
}