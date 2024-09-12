package com.CleverCanines.be.dto.output;

import java.util.UUID;

import com.CleverCanines.be.enums.LessonType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int orderIndex; //order in which the lesson should be displayed

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LessonType lessonType; //either client, raiser or staff

    @Column(nullable = false)
    private int lessonWeek; //week in which the lesson should be displayed
}
