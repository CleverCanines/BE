package com.CleverCanines.be.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.CleverCanines.be.dto.output.LessonInteraction;
import java.util.UUID;
import java.util.List;


@Repository
public interface LessonInteractionRepository extends CrudRepository<LessonInteraction, UUID> {
    List<LessonInteraction> findByPersonId(UUID personId);
    List<LessonInteraction> findByPersonIdAndLessonId(UUID personId, UUID lessonId);
    void deleteByLessonId(UUID lessonId);
}
