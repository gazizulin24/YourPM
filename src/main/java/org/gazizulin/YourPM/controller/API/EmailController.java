package org.gazizulin.YourPM.controller.API;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Timur Gazizulin
 */
@Controller
@RequiredArgsConstructor
public class EmailController {

    private final JavaMailSender mailSender;


    @GetMapping("/email")
    public void SendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("t4ynyyy@gmail.com");
        message.setSubject("Привет!");
        message.setText("Это тестовое сообщение.");
        mailSender.send(message);
    }
}

