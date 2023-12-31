package org.gazizulin.YourPM.controller.API;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.DTO.TaskDTO;
import org.gazizulin.YourPM.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

/**
 * @author Timur Gazizulin
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {


    private final TaskService taskService;

    @PostMapping("/new/{projectId}")
    public RedirectView createTask(@RequestParam(name="name") String name,
                                   @RequestParam(name="description") String description,
                                   @RequestParam(name="deadline") String deadline,
                                   @RequestParam(name="priority") String priority,
                                   @PathVariable("projectId") Integer projectId){
        System.out.println(name);

        taskService.createNewTask(new TaskDTO(name, description, new Date(taskService.deadlineToTimeStamp(deadline)), priority), projectId);

        return new RedirectView("/dashboard/" + projectId);

    }


    @GetMapping("/delete/{id}")
    public RedirectView deleteTask(@PathVariable("id") Integer id){
        Integer projectId = taskService.getProjectIdByTaskId(id);
        taskService.deleteTask(id);
        return new RedirectView("/dashboard/" + projectId);
    }


}
