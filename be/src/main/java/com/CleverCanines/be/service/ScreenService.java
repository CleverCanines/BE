package com.CleverCanines.be.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.output.Screen;
import com.CleverCanines.be.repository.ScreenRepository;

@Service
public class ScreenService {
    
    @Autowired
    private ScreenRepository screenRepository;

    public List<Screen> getScreens() {
        return (List<Screen>) screenRepository.findAllByOrderByOrderIndexAsc();
    }

    public List<Screen> getScreensByTaskId(UUID taskId) {
        return (List<Screen>) screenRepository.findByTaskIdOrderByOrderIndexAsc(taskId);
    }

    public Screen getScreen(UUID id) {
        return screenRepository.findById(id).orElse(null);
    }

    public Screen addScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public Screen updateScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public void deleteScreen(UUID id) {
        screenRepository.deleteById(id);
    }
}
