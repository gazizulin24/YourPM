package org.gazizulin.YourPM.controller.API;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.DTO.ProjectDTO;
import org.gazizulin.YourPM.entity.Project;
import org.gazizulin.YourPM.entity.User;
import org.gazizulin.YourPM.service.ProjectService;
import org.gazizulin.YourPM.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Timur Gazizulin
 */
@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    @PostMapping("/new/{id}")
    public RedirectView createProject(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "deadline") String deadline,
                                      @RequestParam(name = "priority") String priority,
                                      @PathVariable(name = "id") Integer id){
        // bad
        ProjectDTO projectDTO = new ProjectDTO(name,
                new Date(projectService.deadlineToTimeStamp(deadline)), priority);
        projectService.createProject(projectDTO, id);
        return new RedirectView("/dashboard");
    }


    @GetMapping("/get/{id}")
    public List<ProjectDTO> getAllProjects(@PathVariable(name = "id") Integer id){

        return projectService.getAllProjectsToUser(id);
    }

    @PostMapping("/adduser/{projectId}")
    public RedirectView addUserToProject(@RequestParam(name = "username") String username,
                                         @PathVariable(name = "projectId") Integer projectId){
        if (userService.getUserByUsername(username).isPresent()){
            projectService.addUserToProject(projectId, username);
        }
        return new RedirectView("/dashboard");
    }

    @PostMapping("/remove/{projectId}")
    public RedirectView removeUserFromProject(@RequestParam(name = "username") String username,
                                              @PathVariable(name = "projectId") Integer projectId){

        projectService.removeUserFromProject(projectId, username);
        return new RedirectView("/dashboard");
    }
}
