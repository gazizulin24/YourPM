package org.gazizulin.YourPM.controller;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Timur Gazizulin
 */
@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final UserService userService;
    @GetMapping
    public ModelAndView getDashboardPage(Authentication auth){
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();

        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("username", username);
        modelAndView.addObject("id", userService.findIdByUsername(username));

        return modelAndView;
    }
}
