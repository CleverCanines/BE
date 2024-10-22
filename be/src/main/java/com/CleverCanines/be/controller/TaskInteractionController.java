package com.CleverCanines.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import com.CleverCanines.be.dto.output.TaskInteraction;
import com.CleverCanines.be.service.TaskInteractionService;

import java.util.List;
import java.util.UUID;

@Controller
public class TaskInteractionController {
    @Autowired
    private TaskInteractionService taskInteractionService;

    // QueryMappings

    @QueryMapping
    public List<TaskInteraction> getTaskInteractionsByPersonId(@Argument UUID personId) {
        return taskInteractionService.getTaskInteractionsByPersonId(personId);
    }
}
