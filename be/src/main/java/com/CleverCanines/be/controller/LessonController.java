package com.CleverCanines.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.CleverCanines.be.dto.LessonDTO;
import com.CleverCanines.be.service.LessonService;
import java.util.List;

@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @QueryMapping
    public List<LessonDTO> lessons() {
        return lessonService.getLessons();
    }
    
    @QueryMapping
    public LessonDTO lesson(String id) {
        return lessonService.getLesson(id);
    }
}
