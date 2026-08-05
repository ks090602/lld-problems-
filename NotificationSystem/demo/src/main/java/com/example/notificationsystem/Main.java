package com.example.notificationsystem;

import java.util.List;

import com.example.notificationsystem.enums.NotificationChannelType;
import com.example.notificationsystem.model.Notification;
import com.example.notificationsystem.model.NotificationRequest;
import com.example.notificationsystem.model.User;
import com.example.notificationsystem.service.NotificationSystem;

public class Main {
    public static void main(String[] args) {
        NotificationSystem notificationSystem = NotificationSystem.getInstance();
        User user1 = new User("Kunal");
        User user2 = new User("Ayush");
        User user3 = new User("Harsh");
        User user4 = new User("Lila");

        user1.subscribeChannel(NotificationChannelType.EMAIL);
        user1.subscribeChannel(NotificationChannelType.SMS);

        user2.subscribeChannel(NotificationChannelType.EMAIL);

        user3.subscribeChannel(NotificationChannelType.PUSH);
        user3.subscribeChannel(NotificationChannelType.SMS);

        user4.subscribeChannel(NotificationChannelType.EMAIL);
        user4.subscribeChannel(NotificationChannelType.SMS);
        user4.subscribeChannel(NotificationChannelType.PUSH);
        
        NotificationRequest newRequest = new NotificationRequest(List.of(user1,user2,user3,user4), List.of(NotificationChannelType.EMAIL,NotificationChannelType.PUSH,NotificationChannelType.SMS), new Notification("Hi All Users"));

        notificationSystem.sendNotification(newRequest);

        notificationSystem.showHistory();

    }
}