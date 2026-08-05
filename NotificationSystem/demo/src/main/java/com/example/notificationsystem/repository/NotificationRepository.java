package com.example.notificationsystem.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.notificationsystem.record.NotificationRecord;

public class NotificationRepository {
    private final List<NotificationRecord> notificationHistory;
    public NotificationRepository(){
        notificationHistory = Collections.synchronizedList(new ArrayList<>());
    }

    public void addNotificationRecord(NotificationRecord record)
    {
        notificationHistory.add(record);
    }

    public void getNotificationHistory()
    {
        for (NotificationRecord notificationRecord : notificationHistory) {
            System.out.println(notificationRecord);
        }
    }
}
