package org.gazizulin.YourPM.service;

import lombok.AllArgsConstructor;
import org.gazizulin.YourPM.entity.User;
import org.gazizulin.YourPM.repository.UsersRepository;
import org.gazizulin.YourPM.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Timur Gazizulin
 */
@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UsersRepository myUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = myUserRepository.findByName(username);
        System.out.println("im here");
        if(user.isEmpty()){
            System.out.println("username not found");
            throw new UsernameNotFoundException("Username not found");
        }

        return new MyUserDetails(user.get());
    }
}
