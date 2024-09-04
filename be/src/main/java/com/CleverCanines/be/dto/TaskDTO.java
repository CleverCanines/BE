package com.CleverCanines.be.dto;

import java.util.List;
import lombok.Data;

@Data
public class TaskDTO {
    private String id;
    private String title;
    private String description;
    private String lesson; //String is ID of Lesson
    private List<ScreenDTO> screens;
}
