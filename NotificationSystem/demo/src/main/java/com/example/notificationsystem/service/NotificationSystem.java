package com.example.notificationsystem.service;

import java.time.Instant;

import com.example.notificationsystem.enums.DeliveryStatus;
import com.example.notificationsystem.enums.NotificationChannelType;
import com.example.notificationsystem.factory.NotificationChannelFactory;
import com.example.notificationsystem.model.NotificationRequest;
import com.example.notificationsystem.model.User;
import com.example.notificationsystem.record.NotificationRecord;
import com.example.notificationsystem.repository.NotificationRepository;
import com.example.notificationsystem.strategy.NotificationChannel;

// Singleton class
public class NotificationSystem {
    private static final NotificationSystem instance = new NotificationSystem();
    private NotificationRepository notificationRepository;
    private NotificationChannelFactory notificationChannelFactory;
    private NotificationSystem(){
        notificationRepository = new NotificationRepository();
        notificationChannelFactory = new NotificationChannelFactory();
    }

    public static NotificationSystem getInstance(){
        return instance;
    }

    public void sendNotification(NotificationRequest notificationRequest)
    {
        try{
            for(User user:notificationRequest.getUsers())
            {
                for(NotificationChannelType channelType:notificationRequest.getChannels())
                {
                    if(user.getUserPreference().hasChannelPreference(channelType))
                    {
                        NotificationChannel notificationChannel = notificationChannelFactory.getNotificationChannel(channelType);

                        try{
                            notificationChannel.sendNotification(notificationRequest.getNotification(), user);
                            saveNotification(new NotificationRecord(user, channelType, notificationRequest.getNotification(), DeliveryStatus.DELIVERED, Instant.now()));
                        }catch(Exception e)
                        {
                            e.printStackTrace();
                            saveNotification(new NotificationRecord(user, channelType, notificationRequest.getNotification(), DeliveryStatus.FAILED, Instant.now()));
                        }
                    }
                }
            }
        }catch(Exception e)
        {
            System.out.println("Exception Occured " + e.getMessage());
        }
    }

    public void saveNotification(NotificationRecord record)
    {
        notificationRepository.addNotificationRecord(record);
    }

    public void showHistory()
    {
        notificationRepository.getNotificationHistory();
    }
}
