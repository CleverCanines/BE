package com.CleverCanines.be.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.output.Lesson;
import com.CleverCanines.be.enums.LessonType;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, UUID> {
	List<Lesson> findAllByOrderByOrderIndexAsc();
	List<Lesson> findByLessonTypeOrderByOrderIndexAsc(LessonType lessonType);
}
