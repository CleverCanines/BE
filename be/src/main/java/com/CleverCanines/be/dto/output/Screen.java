package com.CleverCanines.be.dto.output;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int orderIndex; //order in which the screen should be displayed

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(nullable = true)
    private String videoUrl; //optional

    @Column(nullable = true)
    private String imageUrl; //optional

    @Column(nullable = false)
    private boolean onlyInstruction; 

    @Column(nullable = false) 
    private UUID taskId; //UUID of the task to which the screen belongs
}
