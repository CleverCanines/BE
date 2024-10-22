package com.CleverCanines.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;

import com.CleverCanines.be.dto.output.LessonInteraction;
import com.CleverCanines.be.service.LessonInteractionService;

import java.util.List;
import java.util.UUID;

@Controller
public class LessonInteractionController {
    @Autowired
    private LessonInteractionService lessonInteractionService;

    // QueryMappings
    
    @QueryMapping
    public List<LessonInteraction> getLessonInteractionsByPersonId(@Argument UUID personId) {
        return lessonInteractionService.getLessonInteractionsByPersonId(personId);
    }
}
