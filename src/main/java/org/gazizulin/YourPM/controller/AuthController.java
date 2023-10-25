package org.gazizulin.YourPM.controller;

import lombok.RequiredArgsConstructor;
import org.gazizulin.YourPM.entity.User;
import org.gazizulin.YourPM.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Timur Gazizulin
 */
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping
    public String getLoginPage()  {
        return "auth/login";
    }

}
