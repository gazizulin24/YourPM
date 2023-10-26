package org.gazizulin.YourPM.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.gazizulin.YourPM.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Timur Gazizulin
 */
@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {

    private Integer id;
    private String name;
    private Date deadline;
    private String priority;
    private List<UserDTO> users = new ArrayList<>();
    private List<TaskDTO> tasks = new ArrayList<>();

    public ProjectDTO(String name, Date deadline, String priority) {
        this.name = name;
        this.deadline = deadline;
        this.priority = priority;
    }
}
