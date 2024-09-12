package com.CleverCanines.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.CleverCanines.be.dto.input.NewLessonOrder;
import com.CleverCanines.be.dto.output.Lesson;
import com.CleverCanines.be.enums.LessonType;
import com.CleverCanines.be.service.LessonService;
import com.CleverCanines.be.service.TaskService;

import java.util.List;
import java.util.UUID;

@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private TaskService taskService;

    // QueryMappings

    @QueryMapping
    public List<Lesson> getLessons() {
        return lessonService.getLessons();
    }

    @QueryMapping
    public List<Lesson> getLessonsByLessonType(@Argument LessonType lesson_type) {
        return lessonService.getLessonsByLessonType(lesson_type);
    }

    @QueryMapping
    public Lesson getLesson(@Argument UUID id) {
        return lessonService.getLesson(id);
    }

    // MutationMappings

    @MutationMapping
    public Lesson addLesson(@Argument Integer orderIndex, @Argument String title, @Argument String description, @Argument LessonType lesson_type, @Argument int lesson_week) {
        Lesson lesson = new Lesson();
        lesson.setOrderIndex(orderIndex);
        lesson.setTitle(title);
        lesson.setDescription(description);
        lesson.setLessonType(lesson_type);
        lesson.setLessonWeek(lesson_week);
        return lessonService.addLesson(lesson);
    }

    @MutationMapping
    public Lesson updateLesson(@Argument UUID id, @Argument String title, @Argument String description, @Argument LessonType lesson_type, @Argument int lesson_week) {
        Lesson lesson = lessonService.getLesson(id);
        lesson.setTitle(title);
        lesson.setDescription(description);
        lesson.setLessonType(lesson_type);
        lesson.setLessonWeek(lesson_week);
        return lessonService.updateLesson(lesson);
    }

    @MutationMapping
    public List<Lesson> updateLessonOrderIndex(@Argument NewLessonOrder newLessonOrder) {
        List<UUID> newOrder = newLessonOrder.getNewOrder();
        List<Integer> newWeeks = newLessonOrder.getNewWeeks();

        for (int i = 0; i < newOrder.size(); i++) {
            Lesson lesson = lessonService.getLesson(newOrder.get(i));
            lesson.setOrderIndex(i);
            lesson.setLessonWeek(newWeeks.get(i));
            lessonService.updateLesson(lesson);
        }
        return lessonService.getLessons();
    }

    @MutationMapping
    public UUID deleteLesson(@Argument UUID id) {
        // cascade delete to tasks
        taskService.getTasksByLessonId(id).forEach(task -> {
            taskService.deleteTask(task.getId());
        });

        lessonService.deleteLesson(id);
        return id;
    }
}
