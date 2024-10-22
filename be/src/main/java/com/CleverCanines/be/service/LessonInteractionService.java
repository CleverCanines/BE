package com.CleverCanines.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.repository.LessonInteractionRepository;
import java.util.UUID;
import com.CleverCanines.be.dto.output.LessonInteraction;
import java.util.List;

@Service
public class LessonInteractionService {
    @Autowired
    private LessonInteractionRepository lessonInteractionRepository;

    public List<LessonInteraction> getLessonInteractionsByPersonId(UUID personId) {
        return lessonInteractionRepository.findByPersonId(personId);
    }

    public LessonInteraction addLessonInteraction(LessonInteraction lessonInteraction) {
        return lessonInteractionRepository.save(lessonInteraction);
    }

    public LessonInteraction updateLessonInteraction(LessonInteraction lessonInteraction) {
        return lessonInteractionRepository.save(lessonInteraction);
    }

    public void deleteLessonInteractionsByLessonId(UUID lessonInteractionId) {
        lessonInteractionRepository.deleteByLessonId(lessonInteractionId);
    }
}
