package org.gazizulin.YourPM.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.gazizulin.YourPM.entity.User;

import java.util.Date;
import java.util.Set;

/**
 * @author Timur Gazizulin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private String name;
    private Date deadline;
    private String priority;
}
