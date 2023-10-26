package org.gazizulin.YourPM.DTO;

import jakarta.persistence.*;
import lombok.*;
import org.gazizulin.YourPM.entity.Project;

import java.util.Date;

/**
 * @author Timur Gazizulin
 */
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Integer id;
    private String name;
    private String description;
    private Date deadline;
    private String state;
    private String priority;

    public TaskDTO(String name, String description, Date deadline, String priority) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }
}
