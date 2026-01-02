package com.example.notifications.controller;

import com.example.notifications.dto.EmailReuest;
import com.example.notifications.dto.ResponseDtos;
import com.example.notifications.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    private EmailNotificationService notificationService;

    @PostMapping("/email/send")
    public ResponseDtos send(@RequestBody EmailReuest request){
        return  notificationService.sendEmail(request.getToMail(), request.getMessage(), request.getSubject());

    }

}
