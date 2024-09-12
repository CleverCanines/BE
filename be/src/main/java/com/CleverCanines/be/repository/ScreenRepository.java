package com.CleverCanines.be.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CleverCanines.be.dto.output.Screen;

@Repository
public interface ScreenRepository extends CrudRepository<Screen, UUID> {
    List<Screen> findAllByOrderByOrderIndexAsc();
    List<Screen> findByTaskIdOrderByOrderIndexAsc(UUID taskId);
}
