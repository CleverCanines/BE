package com.CleverCanines.be.dto.input;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class NewLessonOrder {
    private List<UUID> newOrder; //list of lesson UUIDs in the new order
    private List<Integer> newWeeks; //list of lesson weeks in the new order
}
