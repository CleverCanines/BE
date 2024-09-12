package com.CleverCanines.be.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.Lesson;
import com.CleverCanines.be.enums.LessonType;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {
	List<Lesson> findByLessonType(LessonType lessonType);
}
