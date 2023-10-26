package org.gazizulin.YourPM.controller;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.repository.UsersRepository;
import org.gazizulin.YourPM.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Timur Gazizulin
 */
@RequestMapping("/profile")
@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;


    @GetMapping("/{id}")
    public String profilePage(@PathVariable("id") Integer id
            ,Model model){
        model.addAttribute("username", userService.getUsernameById(id));
        model.addAttribute("id", id);
        return "profile";
    }


    @PostMapping("/{id}")
    public RedirectView changeUserPassword(@PathVariable("id") Integer id,
                                           @RequestParam("newPass") String newPass){
        userService.changePassword(id, newPass);
        return new RedirectView("/dashboard");
    }


}
