package com.CleverCanines.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.CleverCanines.be.dto.Task;
import com.CleverCanines.be.service.TaskService;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @QueryMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @QueryMapping
    public List<Task> getTasksByLessonId(@Argument Integer lessonId) {
        return taskService.getTasksByLessonId(lessonId);
    }

    @QueryMapping
    public Task getTask(@Argument Integer id) {
        return taskService.getTask(id);
    }

    @MutationMapping
    public Task addTask(@Argument String title, @Argument String description, @Argument Integer lessonId) {
        Task newTask = new Task();
        newTask.setTitle(title);
        newTask.setDescription(description);
        newTask.setLessonId(lessonId);
        return taskService.addTask(newTask);
    }

    @MutationMapping
    public Task updateTask(@Argument Integer id, @Argument String title, @Argument String description, @Argument Integer lessonId) {
        Task task = taskService.getTask(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setLessonId(lessonId);
        return taskService.updateTask(task);
    }

    @MutationMapping
    public void deleteTask(@Argument Integer id) {
        taskService.deleteTask(id);
    }
}
