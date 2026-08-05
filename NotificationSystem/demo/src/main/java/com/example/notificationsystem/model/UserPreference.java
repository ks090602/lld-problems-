package com.example.notificationsystem.model;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.example.notificationsystem.enums.NotificationChannelType;

public class UserPreference {
    private Set<NotificationChannelType> channelPreferences;

    public UserPreference()
    {
        channelPreferences = ConcurrentHashMap.newKeySet();
    }

    public void addToList(NotificationChannelType type)
    {
        channelPreferences.add(type);
    }

    public void removeFromList(NotificationChannelType type)
    {
        try {
            if(channelPreferences.contains(type)) {
                channelPreferences.remove(type);
            } else {
                System.out.println("Channel Not exists in the preferences");
            }
        } catch (Exception e) {
            System.out.println("Failed to remove channel from preferences: " + e.getMessage());
        }
    }

    public boolean hasChannelPreference(NotificationChannelType type)
    {
        return channelPreferences.contains(type);
    }
}
