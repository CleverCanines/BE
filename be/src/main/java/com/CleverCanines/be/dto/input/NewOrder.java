package com.CleverCanines.be.dto.input;

import java.util.List;
import java.util.UUID;

import lombok.Data;

//This class is used for both tasks and screens when inserting a new order

@Data
public class NewOrder {
    private List<UUID> newOrder; //list of task UUIDs in the new order
}
