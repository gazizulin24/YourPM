package org.gazizulin.YourPM.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timur Gazizulin
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Size(min = 3, max = 20, message = "Длина имени должна быть от 3 до 20 символов")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name ="email")
    private String email;

    @Column(name="role")
    private String role;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Project> projects = new ArrayList<>();


    public User(String name, String password, String email, String role) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
