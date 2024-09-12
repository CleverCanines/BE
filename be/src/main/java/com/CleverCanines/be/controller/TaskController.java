package com.CleverCanines.be.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.CleverCanines.be.dto.input.NewOrder;
import com.CleverCanines.be.dto.output.Task;
import com.CleverCanines.be.service.TaskService;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    // QueryMappings

    @QueryMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @QueryMapping
    public List<Task> getTasksByLessonId(@Argument UUID lessonId) {
        return taskService.getTasksByLessonId(lessonId);
    }

    @QueryMapping
    public Task getTask(@Argument UUID id) {
        return taskService.getTask(id);
    }

    // MutationMappings

    @MutationMapping
    public Task addTask(@Argument Integer orderIndex, @Argument String title, @Argument String description, @Argument UUID lessonId) {
        Task newTask = new Task();
        newTask.setOrderIndex(orderIndex);
        newTask.setTitle(title);
        newTask.setDescription(description);
        newTask.setLessonId(lessonId);
        return taskService.addTask(newTask);
    }

    @MutationMapping
    public Task updateTask(@Argument UUID id, @Argument String title, @Argument String description, @Argument UUID lessonId) {
        Task task = taskService.getTask(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setLessonId(lessonId);
        return taskService.updateTask(task);
    }

    @MutationMapping
    public List<Task> updateTaskOrderIndex(@Argument NewOrder newOrder) {
        for (int i = 0; i < newOrder.getNewOrder().size(); i++) {
            Task task = taskService.getTask(newOrder.getNewOrder().get(i));
            task.setOrderIndex(i);
            taskService.updateTask(task);
        }
        return taskService.getTasks();
    }

    @MutationMapping
    public UUID deleteTask(@Argument UUID id) {
        taskService.deleteTask(id);
        return id;
    }
}
