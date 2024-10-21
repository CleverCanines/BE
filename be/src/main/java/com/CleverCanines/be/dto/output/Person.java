package com.CleverCanines.be.dto.output;

import java.util.UUID;

import com.CleverCanines.be.enums.Role;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String username; 

    @Column(nullable = true)
    private String dogName; // null if user is staff or has no dog

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; //either client, raiser or staff
}
