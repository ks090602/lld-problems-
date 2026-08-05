package com.example.notificationsystem.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.notificationsystem.enums.NotificationChannelType;
import com.example.notificationsystem.strategy.EmailChannel;
import com.example.notificationsystem.strategy.NotificationChannel;
import com.example.notificationsystem.strategy.PushChannel;
import com.example.notificationsystem.strategy.SmsChannel;

public class NotificationChannelFactory {
    private Map<NotificationChannelType,NotificationChannel> notificationChannels;
    public NotificationChannelFactory()
    {
        notificationChannels = new ConcurrentHashMap<>();
        notificationChannels.put(NotificationChannelType.EMAIL,new EmailChannel());
        notificationChannels.put(NotificationChannelType.SMS,new SmsChannel());
        notificationChannels.put(NotificationChannelType.PUSH,new PushChannel());
    }

    public NotificationChannel getNotificationChannel(NotificationChannelType type)
    {
        return notificationChannels.getOrDefault(type,null);
    }
}
