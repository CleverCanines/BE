package com.CleverCanines.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.Screen;
import com.CleverCanines.be.repository.ScreenRepository;

@Service
public class ScreenService {
    
    @Autowired
    private ScreenRepository screenRepository;

    public List<Screen> getScreens() {
        return (List<Screen>) screenRepository.findAll();
    }

    public List<Screen> getScreensByTaskId(Integer taskId) {
        return (List<Screen>) screenRepository.findByTaskId(taskId);
    }

    public Screen getScreen(Integer id) {
        return screenRepository.findById(id).orElse(null);
    }

    public Screen addScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public Screen updateScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public void deleteScreen(Integer id) {
        screenRepository.deleteById(id);
    }
}
