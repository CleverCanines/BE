package com.CleverCanines.be.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.output.Lesson;
import com.CleverCanines.be.enums.LessonType;
import com.CleverCanines.be.repository.LessonRepository;


@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getLessons() {
        return (List<Lesson>) lessonRepository.findAllByOrderByOrderIndexAsc();
    }

    public List<Lesson> getLessonsByLessonType(LessonType lessonType) {
        return lessonRepository.findByLessonTypeOrderByOrderIndexAsc(lessonType);
    }

    public Lesson getLesson(UUID id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(UUID id) {
        lessonRepository.deleteById(id);
    }
} 