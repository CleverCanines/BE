package com.CleverCanines.be.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
    List<Task> findByLessonId(Integer id);
} 