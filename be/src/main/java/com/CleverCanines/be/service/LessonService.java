package com.CleverCanines.be.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.LessonDTO;
import com.CleverCanines.be.dto.ScreenDTO;
import com.CleverCanines.be.dto.TaskDTO;
import com.CleverCanines.be.enums.LessonType;

import java.util.ArrayList;

@Service
public class LessonService {
    private List<LessonDTO> lessons;

    public LessonService() {
        // TODO: Currently mocking the data instead of fetching it
        // from a DB for the purpose of making the frontend work easier

        lessons = new ArrayList<>();

        //Screens to be added to the task
        ScreenDTO screen = new ScreenDTO();
        screen.setId("0");
        screen.setTitle("Text only screen");
        screen.setText("This is the text only screen of the task");
        // screen.setVideoUrl("https://www.youtube.com/watch?v=uRF9HLpTDyE");
        // screen.setImageUrl("https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png");
        screen.setOnlyInstruction(true);

        ScreenDTO screen2 = new ScreenDTO();
        screen2.setId("1");
        screen2.setTitle("Video and Image Screen");
        screen2.setText("This is the video and image screen of the task");
        screen2.setVideoUrl("https://www.youtube.com/watch?v=uRF9HLpTDyE");
        screen2.setImageUrl("https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png");
        screen2.setOnlyInstruction(false);

        //Tasks to be added to the lesson
        TaskDTO task = new TaskDTO();
        task.setId("0");
        task.setTitle("Task 1");
        task.setDescription("This is a task of the lesson");
        screen.setTask(task.getId());
        screen2.setTask(task.getId());
        List<ScreenDTO> screens = List.of(screen, screen2);
        task.setScreens(screens);

        TaskDTO task2 = new TaskDTO();
        task2.setId("1");
        task2.setTitle("Task 2");
        task2.setDescription("This is another task of the lesson");
        screen.setTask(task2.getId());
        screen2.setTask(task2.getId());
        List<ScreenDTO> screens2 = List.of(screen, screen2);
        task2.setScreens(screens2);

        //Lessons to be added to the list of lessons
        LessonDTO lesson = new LessonDTO();
        lesson.setId("0");
        lesson.setTitle("Lesson 1");
        lesson.setDescription("This is a lesson");
        lesson.setLessonType(LessonType.client);
        task.setLesson(lesson.getId());
        task2.setLesson(lesson.getId());
        List<TaskDTO> tasks = List.of(task, task2);
        lesson.setTasks(tasks);

        LessonDTO lesson2 = new LessonDTO();
        lesson2.setId("1");
        lesson2.setTitle("Lesson 2");
        lesson2.setDescription("This is another lesson");
        lesson2.setLessonType(LessonType.raiser);
        task.setLesson(lesson2.getId());
        task2.setLesson(lesson2.getId());
        List<TaskDTO> tasks2 = List.of(task, task2);
        lesson2.setTasks(tasks2);

        LessonDTO lesson3 = new LessonDTO();
        lesson3.setId("3");
        lesson3.setTitle("Lesson 3");
        lesson3.setDescription("This is a lesson");
        lesson3.setLessonType(LessonType.client);
        task.setLesson(lesson3.getId());
        task2.setLesson(lesson3.getId());
        List<TaskDTO> tasks3 = List.of(task, task2);
        lesson3.setTasks(tasks3);

        LessonDTO lesson4 = new LessonDTO();
        lesson4.setId("4");
        lesson4.setTitle("Lesson 4");
        lesson4.setDescription("This is another lesson");
        lesson4.setLessonType(LessonType.raiser);
        task.setLesson(lesson4.getId());
        task2.setLesson(lesson4.getId());
        List<TaskDTO> tasks4 = List.of(task, task2);
        lesson4.setTasks(tasks4);

        lessons = List.of(lesson, lesson2, lesson3, lesson4);
    }

    public List<LessonDTO> getLessons() {
        return lessons;
    }

    public LessonDTO getLesson(String id) {
        if (id == null) {
            return null;
        }
        return lessons.get(Integer.parseInt(id));
    }
}
