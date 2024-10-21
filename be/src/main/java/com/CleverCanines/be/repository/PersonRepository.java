package com.CleverCanines.be.repository;

import java.util.List;
import java.util.UUID;

import com.CleverCanines.be.enums.Role;
import com.CleverCanines.be.dto.output.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
    List<Person> findByRole(Role role);
}
