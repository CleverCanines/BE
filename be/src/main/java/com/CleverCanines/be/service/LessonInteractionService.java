package com.CleverCanines.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.repository.LessonInteractionRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import com.CleverCanines.be.dto.output.LessonInteraction;
import java.util.List;

@Service
@Slf4j
public class LessonInteractionService {
    @Autowired
    private LessonInteractionRepository lessonInteractionRepository;

    public List<LessonInteraction> getLessonInteractionsByPersonId(UUID personId) {
        return lessonInteractionRepository.findByPersonId(personId);
    }

    public LessonInteraction addLessonInteraction(LessonInteraction lessonInteraction) {
        //check if the lesson interaction already exists
        List<LessonInteraction> lessonInteractions = lessonInteractionRepository.findByPersonIdAndLessonId(lessonInteraction.getPersonId(), lessonInteraction.getLessonId());
        if (lessonInteractions.size() > 0) {
            // if it does, update the existing lesson interaction
            LessonInteraction existingLessonInteraction = lessonInteractions.get(0);
            existingLessonInteraction.setProgress(lessonInteraction.getProgress());
            return lessonInteractionRepository.save(existingLessonInteraction);
        }
        return lessonInteractionRepository.save(lessonInteraction);
    }

    public LessonInteraction updateLessonInteraction(LessonInteraction lessonInteraction) {
        return lessonInteractionRepository.save(lessonInteraction);
    }

    public void deleteLessonInteractionsByLessonId(UUID lessonInteractionId) {
        lessonInteractionRepository.deleteByLessonId(lessonInteractionId);
    }
}
