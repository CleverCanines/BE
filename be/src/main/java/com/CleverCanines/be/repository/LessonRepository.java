package com.CleverCanines.be.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.Lesson;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {
	
}
