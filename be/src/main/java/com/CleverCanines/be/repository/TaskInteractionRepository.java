package com.CleverCanines.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.output.TaskInteraction;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskInteractionRepository extends CrudRepository<TaskInteraction, UUID> {
    List<TaskInteraction> findByPersonId(UUID personId);
    List<TaskInteraction> findByPersonIdAndTaskId(UUID personId, UUID taskId);
    void deleteByTaskId(UUID taskId);
}