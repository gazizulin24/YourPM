package org.gazizulin.YourPM.service;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.DTO.TaskDTO;
import org.gazizulin.YourPM.entity.Project;
import org.gazizulin.YourPM.entity.Task;
import org.gazizulin.YourPM.repository.ProjectRepository;
import org.gazizulin.YourPM.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Timur Gazizulin
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public void createNewTask(TaskDTO taskDTO, Integer projectId){
        Project project = projectRepository.findById(projectId).orElseThrow();
        Task task = mapFromDTO(taskDTO);
        task.setState("В процессе");
        task.setProject(project);
        taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Integer taskId){
        taskRepository.deleteById(taskId);
    }


    public Integer getProjectIdByTaskId(Integer taskId){
        return taskRepository.findById(taskId).orElseThrow().getProject().getId();
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

    public Task mapFromDTO(TaskDTO taskDTO){
        return modelMapper.map(taskDTO, Task.class);
    }

    public TaskDTO mapToDTO(Task task){
        return modelMapper.map(task, TaskDTO.class);
    }


}
