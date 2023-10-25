package org.gazizulin.YourPM.service;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.entity.Project;
import org.gazizulin.YourPM.entity.User;
import org.gazizulin.YourPM.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Timur Gazizulin
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public Integer findIdByUsername(String username){
        return usersRepository.findByName(username).orElseThrow().getId();
    }


    public List<Project> getAllProjectsFromUserId(Integer id){
        User user = usersRepository.findById(id).orElseThrow();
        return user.getProjects();
    }

}
