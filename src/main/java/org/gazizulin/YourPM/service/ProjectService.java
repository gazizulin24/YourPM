package org.gazizulin.YourPM.service;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.DTO.ProjectDTO;
import org.gazizulin.YourPM.entity.Project;
import org.gazizulin.YourPM.entity.User;
import org.gazizulin.YourPM.repository.ProjectRepository;
import org.gazizulin.YourPM.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Timur Gazizulin
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void createProject(ProjectDTO projectDTO, Integer creatorId){
        User creator = usersRepository.findById(creatorId).orElseThrow();
        Project project = mapFromDTO(projectDTO);
        project.setUsers(List.of(creator));
        project.setTasks(new ArrayList<>());
        project.setState("В процессе");
        projectRepository.save(project);
    }


    public List<Project> getAllProjectsToUser(Integer id){
        User user = usersRepository.findById(id).orElseThrow();
        user.getProjects().forEach(project -> System.out.println(project.getName()));
        return user.getProjects();
    }


    public long deadlineToTimeStamp(String dateString){
        String format = "dd.MM.yyyy";
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateString).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    private Project mapFromDTO(ProjectDTO dto){
        return modelMapper.map(dto, Project.class);
    }
}
