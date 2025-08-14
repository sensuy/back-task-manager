package com.sensui.taskmanager.exception;

import java.time.LocalDateTime;

public record ValidationError(String message, LocalDateTime timestamp) {

    public ValidationError(String message) {
        this(message, LocalDateTime.now());
    }
}
