package com.CleverCanines.be.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TaskInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
 
    @Column(nullable = false)
    private UUID taskId;

    @Column(nullable = false)
    private UUID personId;

    @Column(nullable = false)
    private int progress; //percentage of completion of the task, as an integer between 0 and 100
}
