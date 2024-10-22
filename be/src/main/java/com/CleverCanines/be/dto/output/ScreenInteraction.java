package com.CleverCanines.be.dto.output;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

import java.util.UUID;

@Data
@Entity
public class ScreenInteraction {
    @Column(nullable = false)
    private UUID screenId;

    @Column(nullable = false)
    private UUID personId;

    @Column(nullable = false)
    private boolean complete;
}
