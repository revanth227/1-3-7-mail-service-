package com.example.notifications.dto;

import java.time.LocalDateTime;

public class ResponseDtos {
    private Status status;
    private LocalDateTime localDateTime;

    public ResponseDtos(Status status, LocalDateTime localDateTime) {
        this.status = status;
        this.localDateTime = localDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
