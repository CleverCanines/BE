package com.CleverCanines.be.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CleverCanines.be.dto.output.LessonInteraction;
import com.CleverCanines.be.dto.output.Screen;
import com.CleverCanines.be.dto.output.ScreenInteraction;
import com.CleverCanines.be.dto.output.Task;
import com.CleverCanines.be.dto.output.TaskInteraction;
import com.CleverCanines.be.repository.ScreenInteractionRepository;

@Service
public class ScreenInteractionService {
    @Autowired
    private LessonInteractionService lessonInteractionService;

    @Autowired 
    private TaskInteractionService taskInteractionService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ScreenInteractionRepository screenInteractionRepository;

    @Autowired
    private ScreenService screenService;

    public List<ScreenInteraction> getScreensInteractionsByPersonId(UUID personId) {
        return screenInteractionRepository.findByPersonId(personId);
    }

    /*
     * The easiest way to think about this is that the lesson structure is a tree
     * where the root is a lesson. Each lesson has leaves that are tasks. Each task
     * has leaves that are screens. 
     * 
     * First we need to work our way up the tree to the root so that we know which 
     * lessons and tasks to update.
     * 
     * Next we want to count all the screens in the task also keeping track of the
     * screens that have been completed. The task interactions percentage is the
     * (number of screens completed) / (total number of screens), as an int 0-100 obviously.
     * 
     * Next we can update the lesson interaction with the new percentage. We can do 
     * getting the task interaction percentage for all other tasks in the lesson and
     * then averaging them to get the lesson interaction percentage.
     */
    private void cascadeEffects(ScreenInteraction screenInteraction) {
        // Going up the tree to find the associated task and lesson
        // get the screen associated with the screen interaction
        UUID screenId = screenInteraction.getScreenId();
        Screen screen = screenService.getScreen(screenId);
        // get the task associated with the screen
        UUID taskId = screen.getTaskId();
        Task task = taskService.getTask(taskId);
        // get the lesson associated with the task
        UUID lessonId = task.getLessonId();

        // Updating the task interaction percentage
        // get the all the screens in the task
        List<UUID> screens = screenService.getScreensByTaskId(taskId).stream().map(Screen::getId).toList();
        // get all the screen interaction for the tasks that also match the personId
        List<ScreenInteraction> screenInteractions = getAllScreenInteractionsForScreensByPersonId(screenInteraction.getPersonId(), screens);
        // count the number of screens that have been completed
        int numScreensCompleted = 0;
        for (ScreenInteraction si : screenInteractions) {
            if (si.isComplete()) {
                numScreensCompleted++;
            }
        }
        // calculate the task interaction percentage
        int taskInteractionPercentage = (int)((numScreensCompleted / ((double) screens.size())) * 100);
        // update the task interaction
        taskInteractionService.addTaskInteraction(new TaskInteraction(UUID.randomUUID(), taskId, screenInteraction.getPersonId(), taskInteractionPercentage));

        // Updating the lesson interaction percentage
        // get all the tasks in the lesson
        List<UUID> tasks = taskService.getTasksByLessonId(lessonId).stream().map(Task::getId).toList();
        // get all the task interactions for the tasks that also match the personId
        List<TaskInteraction> taskInteractions = getAllTaskInteractionsForTasksByPersonId(screenInteraction.getPersonId(), tasks);
        // average the task interaction percentages to get the lesson interaction percentage, if there is no task interaction then the percentage is 0
        double lessonInteractionPercentage = 0;
        if (taskInteractions.size() > 0) {
            double sum = 0.0;
            for (TaskInteraction ti : taskInteractions) {
                sum += ti.getProgress();
            }
            lessonInteractionPercentage = sum / taskInteractions.size();
        }
        // update the lesson interaction
        lessonInteractionService.addLessonInteraction(new LessonInteraction(UUID.randomUUID(), screenInteraction.getPersonId(), lessonId, (int)lessonInteractionPercentage));
    }
    
    private List<ScreenInteraction> getAllScreenInteractionsForScreensByPersonId(UUID personId, List<UUID> screens) {
        List<ScreenInteraction> screenInteractions = new ArrayList<>();
        for (UUID screen : screens) {
            screenInteractions.addAll(screenInteractionRepository.findByPersonIdAndScreenId(personId, screen));
        }
        return screenInteractions;
    }

    private List<TaskInteraction> getAllTaskInteractionsForTasksByPersonId(UUID personId, List<UUID> tasks) {
        List<TaskInteraction> taskInteractions = new ArrayList<>();
        for (UUID task : tasks) {
            taskInteractions.addAll(taskInteractionService.getTaskInteractionsByPersonIdAndTaskId(personId, task));
        }
        return taskInteractions;
    }

    public ScreenInteraction addScreenInteraction(ScreenInteraction screenInteraction) {
        // check the state of the screen interaction by screenId and personId
        List <ScreenInteraction> curScreenInteraction = screenInteractionRepository.findByPersonIdAndScreenId(
            screenInteraction.getPersonId(), 
            screenInteraction.getScreenId()
            );
        if (curScreenInteraction.size() <= 0) { // the screen interaction does not already exist
            ScreenInteraction tempScreenInteraction = screenInteractionRepository.save(screenInteraction);
            cascadeEffects(tempScreenInteraction);
            return tempScreenInteraction;

        } 
        else { // the screen interaction already exists
            if (curScreenInteraction.get(0).isComplete() != screenInteraction.isComplete()) { // is the state the different?  
                ScreenInteraction tempScreenInteraction = screenInteractionRepository.save(screenInteraction);
                cascadeEffects(tempScreenInteraction);
                return tempScreenInteraction;
            } 
            else { // the state is the same no need to add the screen interaction or cascade the effects
                return null;
            }
        }
    }

    public ScreenInteraction updateScreenInteraction(ScreenInteraction screenInteraction) {
        // just calls the add both have to check if the screen interaction already exists anyway
        return addScreenInteraction(screenInteraction);
    }

    public void deleteScreenInteraction(UUID personId, UUID screenId) {
        // get the screen interaction
        List<ScreenInteraction> screenInteractions = screenInteractionRepository.findByPersonIdAndScreenId(personId, screenId);
        if (screenInteractions.size() > 0) {
            // delete the screen interaction
            screenInteractionRepository.deleteByPersonIdAndScreenId(personId, screenId);
            // cascade the effects
            cascadeEffects(screenInteractions.get(0));
        }
    }

    public void deleteScreenInteractionsByScreenId(UUID screenId) {
        // get the screen interactions
        List<ScreenInteraction> screenInteractions = screenInteractionRepository.findByScreenId(screenId);
        for (ScreenInteraction si : screenInteractions) {
            // delete the screen interaction
            screenInteractionRepository.deleteByPersonIdAndScreenId(si.getPersonId(), screenId);
            // cascade the effects
            cascadeEffects(si);
        }
    }
}
