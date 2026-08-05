package com.example.logger.model;

import java.time.Instant;

import com.example.logger.enums.LogLevel;

public class LogMessage {
    private final LogLevel logLevel;
    private final String message;
    private final Instant timestamp;

    public LogMessage(LogLevel logLevel,String message)
    {
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = Instant.now();
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
