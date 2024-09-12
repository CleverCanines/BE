package com.CleverCanines.be.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.output.Task;
import com.CleverCanines.be.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ScreenService screenService;

    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAllByOrderByOrderIndexAsc();
    }

    public List<Task> getTasksByLessonId(UUID id) {
        return (List<Task>) taskRepository.findByLessonIdOrderByOrderIndexAsc(id);
    }

    public Task getTask(UUID id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(UUID id) {
        // cascade delete to screens
        screenService.getScreensByTaskId(id).forEach(screen -> {
            screenService.deleteScreen(screen.getId());
        });
        
        taskRepository.deleteById(id);
    }
}
