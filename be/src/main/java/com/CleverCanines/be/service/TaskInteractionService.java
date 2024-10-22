package com.CleverCanines.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.repository.TaskInteractionRepository;
import java.util.UUID;
import com.CleverCanines.be.dto.output.TaskInteraction;
import java.util.List;

@Service
public class TaskInteractionService {
    @Autowired
    private TaskInteractionRepository taskInteractionRepository;

    public List<TaskInteraction> getTaskInteractionsByPersonId(UUID personId) {
        return taskInteractionRepository.findByPersonId(personId);
    }

    public TaskInteraction addTaskInteraction(TaskInteraction taskInteraction) {
        return taskInteractionRepository.save(taskInteraction);
    }

    public TaskInteraction updateTaskInteraction(TaskInteraction taskInteraction) {
        return taskInteractionRepository.save(taskInteraction);
    }

    public void deleteTaskInteraction(UUID taskInteractionId) {
        taskInteractionRepository.deleteById(taskInteractionId);
    }
}