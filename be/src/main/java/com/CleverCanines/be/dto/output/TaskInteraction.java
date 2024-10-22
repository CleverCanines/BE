package com.CleverCanines.be.dto.output;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

import java.util.UUID;

@Data
@Entity
public class TaskInteraction {
    @Column(nullable = false)
    private UUID taskId;

    @Column(nullable = false)
    private UUID personId;

    @Column(nullable = false)
    private int progress; //percentage of completion of the task, as an integer between 0 and 100
}
