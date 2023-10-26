package org.gazizulin.YourPM.service;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.DTO.UserDTO;
import org.gazizulin.YourPM.entity.Project;
import org.gazizulin.YourPM.entity.User;
import org.gazizulin.YourPM.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Timur Gazizulin
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;

    public Integer findIdByUsername(String username){
        return usersRepository.findByName(username).orElseThrow().getId();
    }


    public List<Project> getAllProjectsFromUserId(Integer id){
        User user = usersRepository.findById(id).orElseThrow();
        return user.getProjects();
    }

    @Transactional
    public void createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    public UserDTO mapToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public User mapFromDTO(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

}
