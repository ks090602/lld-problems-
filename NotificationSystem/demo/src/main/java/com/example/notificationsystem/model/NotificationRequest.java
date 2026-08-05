package com.example.notificationsystem.model;

import java.util.List;

import com.example.notificationsystem.enums.NotificationChannelType;


public class NotificationRequest {
    private List<User> users;
    private List<NotificationChannelType> channels;
    private Notification notification;

    public NotificationRequest(List<User> users,List<NotificationChannelType> channels,Notification notification)
    {
        this.users = users;
        this.channels = channels;
        this.notification = notification; 
    }

    public List<User> getUsers() {
        return users;
    }

    public List<NotificationChannelType> getChannels() {
        return channels;
    }

    public Notification getNotification() {
        return notification;
    }
}
