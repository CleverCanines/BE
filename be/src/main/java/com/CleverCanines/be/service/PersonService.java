package com.CleverCanines.be.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.repository.PersonRepository;
import com.CleverCanines.be.enums.Role;
import com.CleverCanines.be.dto.output.Person;
import java.util.UUID;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public List<Person> getPersonsByRole(Role role) {
        return personRepository.findByRole(role);
    }

    public Person getPerson(UUID id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(UUID id) {
        personRepository.deleteById(id);
    }
}
