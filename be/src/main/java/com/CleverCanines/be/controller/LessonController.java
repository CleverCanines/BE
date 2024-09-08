package com.CleverCanines.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.CleverCanines.be.dto.Lesson;
import com.CleverCanines.be.enums.LessonType;
import com.CleverCanines.be.service.LessonService;
import com.CleverCanines.be.service.TaskService;

import java.util.List;

@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private TaskService taskService;

    @QueryMapping
    public List<Lesson> getLessons() {
        return lessonService.getLessons();
    }

    @QueryMapping
    public Lesson getLesson(@Argument Integer id) {
        return lessonService.getLesson(id);
    }

    @MutationMapping
    public Lesson addLesson(@Argument String title, @Argument String description, @Argument LessonType lesson_type) {
        Lesson newLesson = new Lesson();
        newLesson.setTitle(title);
        newLesson.setDescription(description);
        newLesson.setLesson_type(lesson_type);
        return lessonService.addLesson(newLesson);
    }

    @MutationMapping
    public Lesson updateLesson(@Argument Integer id, @Argument String title, @Argument String description, @Argument LessonType lesson_type) {
        Lesson lesson = lessonService.getLesson(id);
        lesson.setTitle(title);
        lesson.setDescription(description);
        lesson.setLesson_type(lesson_type);
        return lessonService.updateLesson(lesson);
    }

    @MutationMapping
    public void deleteLesson(@Argument Integer id) {
        // cascade delete to tasks
        taskService.getTasksByLessonId(id).forEach(task -> {
            taskService.deleteTask(task.getId());
        });

        lessonService.deleteLesson(id);
    }
}
