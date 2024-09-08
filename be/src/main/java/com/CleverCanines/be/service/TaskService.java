package com.CleverCanines.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.Task;
import com.CleverCanines.be.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ScreenService screenService;

    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    public List<Task> getTasksByLessonId(Integer id) {
        return (List<Task>) taskRepository.findByLessonId(id);
    }

    public Task getTask(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        // cascade delete to screens
        screenService.getScreensByTaskId(id).forEach(screen -> {
            screenService.deleteScreen(screen.getId());
        });
        
        taskRepository.deleteById(id);
    }
}
