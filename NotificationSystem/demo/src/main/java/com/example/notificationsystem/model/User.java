package com.example.notificationsystem.model;

import java.util.concurrent.atomic.AtomicInteger;

import com.example.notificationsystem.enums.NotificationChannelType;

public class User {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private int id;
    private String name;
    private UserPreference userPreference;



    public User(String name)
    {
        this.id = AUTO_ID.incrementAndGet();
        this.name = name;
        this.userPreference = new UserPreference();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserPreference getUserPreference() {
        return userPreference;
    }
    
    public void subscribeChannel(NotificationChannelType channelType)
    {
        userPreference.addToList(channelType);
    }

    public void unSubscribeChannel(NotificationChannelType channelType)
    {
        userPreference.removeFromList(channelType);
    }
}
