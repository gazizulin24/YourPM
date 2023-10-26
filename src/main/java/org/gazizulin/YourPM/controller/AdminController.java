package org.gazizulin.YourPM.controller;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.controller.API.EmailController;
import org.gazizulin.YourPM.entity.User;
import org.gazizulin.YourPM.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Timur Gazizulin
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;


    @GetMapping
    public String adminPage(){
        return "admin";
    }

    @PostMapping("/new")
    public String createUser(@RequestParam(name = "name") String name,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "role") String role){

        userService.createUser(new User(name, password, email, role));
        return "redirect:/admin";
    }
}

