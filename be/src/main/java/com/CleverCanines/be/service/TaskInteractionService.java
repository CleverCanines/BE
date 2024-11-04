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

    public List<TaskInteraction> getTaskInteractionsByPersonIdAndTaskId(UUID personId, UUID taskId) {
        return taskInteractionRepository.findByPersonIdAndTaskId(personId, taskId);
    }

    public TaskInteraction addTaskInteraction(TaskInteraction taskInteraction) {
        // check if the task interaction already exists
        List<TaskInteraction> taskInteractions = taskInteractionRepository.findByPersonIdAndTaskId(taskInteraction.getPersonId(), taskInteraction.getTaskId());
        if (taskInteractions.size() > 0) {
            // if it does, update the existing task interaction
            TaskInteraction existingTaskInteraction = taskInteractions.get(0);
            existingTaskInteraction.setProgress(taskInteraction.getProgress());
            return taskInteractionRepository.save(existingTaskInteraction);
        }
        return taskInteractionRepository.save(taskInteraction);
    }

    public TaskInteraction updateTaskInteraction(TaskInteraction taskInteraction) {
        return taskInteractionRepository.save(taskInteraction);
    }

    public void deleteTaskInteractionsByTaskId(UUID taskInteractionId) {
        taskInteractionRepository.deleteByTaskId(taskInteractionId);
    }
}
