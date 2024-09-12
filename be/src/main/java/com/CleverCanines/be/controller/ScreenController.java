package com.CleverCanines.be.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.CleverCanines.be.dto.input.NewOrder;
import com.CleverCanines.be.dto.output.Screen;
import com.CleverCanines.be.service.ScreenService;

@Controller
public class ScreenController {
    @Autowired 
    private ScreenService screenService;

    // QueryMappings

    @QueryMapping
    public List<Screen> getScreens() {
        return screenService.getScreens();
    }

    @QueryMapping
    public List<Screen> getScreensByTaskId(@Argument UUID taskId) {
        return screenService.getScreensByTaskId(taskId);
    }

    @QueryMapping
    public Screen getScreen(@Argument UUID id) {
        return screenService.getScreen(id);
    }

    // MutationMappings
    
    @MutationMapping
    public Screen addScreen(@Argument Integer orderIndex, @Argument String title, @Argument String text, @Argument String videoUrl, @Argument String imageUrl, @Argument boolean onlyInstruction, @Argument UUID taskId) {
        Screen newScreen = new Screen();
        newScreen.setOrderIndex(orderIndex);
        newScreen.setTitle(title);
        newScreen.setText(text);
        newScreen.setVideoUrl(videoUrl);
        newScreen.setImageUrl(imageUrl);
        newScreen.setOnlyInstruction(onlyInstruction);
        newScreen.setTaskId(taskId);
        return screenService.addScreen(newScreen);
    }

    @MutationMapping
    public Screen updateScreen(@Argument UUID id, @Argument String title, @Argument String text, @Argument String videoUrl, @Argument String imageUrl, @Argument boolean onlyInstruction, @Argument UUID taskId) {
        Screen screen = screenService.getScreen(id);
        screen.setTitle(title);
        screen.setText(text);
        screen.setVideoUrl(videoUrl);
        screen.setImageUrl(imageUrl);
        screen.setOnlyInstruction(onlyInstruction);
        screen.setTaskId(taskId);
        return screenService.updateScreen(screen);
    }

    @MutationMapping
    public List<Screen> updateScreenOrderIndex(@Argument NewOrder newOrder) {
        for (int i = 0; i < newOrder.getNewOrder().size(); i++) {
            Screen screen = screenService.getScreen(newOrder.getNewOrder().get(i));
            screen.setOrderIndex(i);
            screenService.updateScreen(screen);
        }
        return screenService.getScreens();
    }

    @MutationMapping
    public UUID deleteScreen(@Argument UUID id) {
        screenService.deleteScreen(id);
        return id;
    }
}
