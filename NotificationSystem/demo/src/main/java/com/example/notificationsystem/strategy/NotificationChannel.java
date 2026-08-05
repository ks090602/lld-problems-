package com.example.notificationsystem.strategy;

import com.example.notificationsystem.model.Notification;
import com.example.notificationsystem.model.User;

public interface NotificationChannel {
    void sendNotification(Notification notification,User user);
}
