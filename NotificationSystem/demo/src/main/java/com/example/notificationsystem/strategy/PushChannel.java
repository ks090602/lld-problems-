package com.example.notificationsystem.strategy;

import com.example.notificationsystem.model.Notification;
import com.example.notificationsystem.model.User;

public class PushChannel implements NotificationChannel{
    @Override
    public void sendNotification(Notification notification,User user)
    {
        System.out.println("A Notification : " + notification.getMessage() + " with id " + notification.getId() + " is sent to user : " +  user.getName() + " via Push Channel");
    }
}
