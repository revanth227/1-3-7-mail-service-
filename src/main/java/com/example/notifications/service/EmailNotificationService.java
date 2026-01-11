package com.example.notifications.service;

import com.example.notifications.dto.ResponseDtos;
import com.example.notifications.dto.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailNotificationService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public ResponseDtos sendEmail(String recipient, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Rewise Support <" + fromEmail + ">");
        message.setTo(recipient);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);


        return new ResponseDtos(Status.SUCCESS, LocalDateTime.now());
    }

}
