package com.CleverCanines.be.dto;

import lombok.Data;

@Data
public class ScreenDTO {
    private String id;
    private String title;
    private String task; //String is ID of Task
    private String text;
    private String videoUrl; //optional
    private String imageUrl; //optional
    private boolean onlyInstruction; 
}
