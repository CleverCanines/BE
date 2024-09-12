package com.CleverCanines.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.Lesson;
import com.CleverCanines.be.enums.LessonType;
import com.CleverCanines.be.repository.LessonRepository;


@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getLessons() {
        return (List<Lesson>) lessonRepository.findAll();
    }

    public List<Lesson> getLessonsByLessonType(LessonType lessonType) {
        return lessonRepository.findByLessonType(lessonType);
    }

    public Lesson getLesson(Integer id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(Integer id) {
        lessonRepository.deleteById(id);
    }
} 