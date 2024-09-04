package com.CleverCanines.be.dto;

import java.util.List;
import lombok.Data;
import com.CleverCanines.be.enums.LessonType;

@Data
public class LessonDTO {
    private String id;
    private String title;
    private String description;
    private LessonType lessonType; //either client or raiser
    private List<TaskDTO> tasks;
}
