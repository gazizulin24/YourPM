package org.gazizulin.YourPM.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Timur Gazizulin
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @Column(name="name")
    private String name;


    @Column(name="deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Column(name="priority")
    private String priority;

    @Column(name = "state")
    private String state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_project",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;


    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();
}
