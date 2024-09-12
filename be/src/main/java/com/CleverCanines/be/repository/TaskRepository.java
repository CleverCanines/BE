package com.CleverCanines.be.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.output.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {
    List<Task> findAllByOrderByOrderIndexAsc();
    List<Task> findByLessonIdOrderByOrderIndexAsc(UUID id);
} 