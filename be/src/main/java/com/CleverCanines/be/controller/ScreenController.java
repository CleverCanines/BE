package com.CleverCanines.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.CleverCanines.be.dto.Screen;
import com.CleverCanines.be.service.ScreenService;

@Controller
public class ScreenController {
    @Autowired 
    private ScreenService screenService;

    @QueryMapping
    public List<Screen> getScreens() {
        return screenService.getScreens();
    }

    @QueryMapping
    public List<Screen> getScreensByTaskId(@Argument Integer taskId) {
        return screenService.getScreensByTaskId(taskId);
    }

    @QueryMapping
    public Screen getScreen(@Argument Integer id) {
        return screenService.getScreen(id);
    }
    
    @MutationMapping
    public Screen addScreen(@Argument String title, @Argument String text, @Argument String videoUrl, @Argument String imageUrl, @Argument boolean onlyInstruction, @Argument Integer taskId) {
        Screen newScreen = new Screen();
        newScreen.setTitle(title);
        newScreen.setText(text);
        newScreen.setVideoUrl(videoUrl);
        newScreen.setImageUrl(imageUrl);
        newScreen.setOnlyInstruction(onlyInstruction);
        newScreen.setTaskId(taskId);
        return screenService.addScreen(newScreen);
    }

    @MutationMapping
    public Screen updateScreen(@Argument Integer id, @Argument String title, @Argument String text, @Argument String videoUrl, @Argument String imageUrl, @Argument boolean onlyInstruction, @Argument Integer taskId) {
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
    public void deleteScreen(@Argument Integer id) {
        screenService.deleteScreen(id);
    }
}
