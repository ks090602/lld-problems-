package com.example.notificationsystem.model;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;


public class Notification {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private int id;
    private String message;
    private Instant timeStamp;

    public Notification(String message)
    {
        this.id = AUTO_ID.incrementAndGet();
        this.message = message;
        this.timeStamp = Instant.now();
    }

    public int getId()
    {
        return id;
    }

    public String getMessage()
    {
        return message;
    }

    public Instant getTimeStamp()
    {
        return timeStamp;
    }
}
