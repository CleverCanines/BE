package com.CleverCanines.be.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.Screen;

@Repository
public interface ScreenRepository extends CrudRepository<Screen, Integer> {
    List<Screen> findByTaskId(Integer taskId);
}
