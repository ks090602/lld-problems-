package com.example.notificationsystem.record;

import java.time.Instant;

import com.example.notificationsystem.enums.DeliveryStatus;
import com.example.notificationsystem.enums.NotificationChannelType;
import com.example.notificationsystem.model.Notification;
import com.example.notificationsystem.model.User;

// keeping it as a record as it is basically a DTO - Data Transfer Object which is in between Service Layer and Repository Layer 
public record NotificationRecord(User user, NotificationChannelType channelType,Notification notification, DeliveryStatus deliveryStatus, Instant timeStamp) {
    
    public NotificationRecord withStatus(DeliveryStatus newStatus)
    {
        return new NotificationRecord(this.user, this.channelType, this.notification, newStatus, Instant.now());
    } 
}
