package com.CleverCanines.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.CleverCanines.be.dto.output.ScreenInteraction;
import com.CleverCanines.be.service.ScreenInteractionService;

import java.util.List;
import java.util.UUID;

@Controller
public class ScreenInteractionController {
    @Autowired
    private ScreenInteractionService screenInteractionService;

    // QueryMappings

    @QueryMapping
    public List<ScreenInteraction> getScreenInteractionsByPersonId(UUID personId) {
        return screenInteractionService.getScreensInteractionsByPersonId(personId);
    }

    // MutationMappings

    @MutationMapping
    public ScreenInteraction addScreenInteraction(@Argument UUID screenId, @Argument UUID personId, @Argument boolean complete) {
        ScreenInteraction screenInteraction = new ScreenInteraction();
        screenInteraction.setScreenId(screenId);
        screenInteraction.setPersonId(personId);
        screenInteraction.setComplete(complete);
        return screenInteractionService.addScreenInteraction(screenInteraction);
    }

    @MutationMapping
    public ScreenInteraction updateScreenInteraction(@Argument UUID screenId, @Argument UUID personId, @Argument boolean complete) {
        ScreenInteraction screenInteraction = new ScreenInteraction();
        screenInteraction.setScreenId(screenId);
        screenInteraction.setPersonId(personId);
        screenInteraction.setComplete(complete);
        return screenInteractionService.addScreenInteraction(screenInteraction);
    }
}
