package com.example.notifications.service;

import com.example.notifications.dto.ResponseDtos;
import com.example.notifications.dto.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class EmailNotificationService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${brevo.sender.email}")
    private String senderEmail;

    @Value("${brevo.sender.name}")
    private String senderName;

    private static final String BREVO_URL =
            "https://api.brevo.com/v3/smtp/email";

    public ResponseDtos sendEmail(String to, String body, String subject) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", apiKey);

        String payload = """
        {
          "sender": {
            "name": "%s",
            "email": "%s"
          },
          "to": [
            {
              "email": "%s"
            }
          ],
          "subject": "%s",
          "htmlContent": "<html><body><p>%s</p></body></html>"
        }
        """.formatted(senderName, senderEmail, to, subject, body);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        restTemplate.postForEntity(BREVO_URL, entity, String.class);

        return new ResponseDtos(Status.SUCCESS, LocalDateTime.now());
    }
}

