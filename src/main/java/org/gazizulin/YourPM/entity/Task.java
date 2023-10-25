package org.gazizulin.YourPM.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * @author Timur Gazizulin
 */
@Entity
@Table(name = "task")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "state")
    private String state;

    @Column(name = "priority")
    private String priority;

}
