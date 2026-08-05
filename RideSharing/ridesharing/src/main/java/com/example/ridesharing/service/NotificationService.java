package com.example.ridesharing.service;

import com.example.ridesharing.model.Ride;

public class NotificationService {
    public void notify(Ride ride)
    {
        System.out.println("Hi User: " + ride.getUser().getName() + ", your ride is confirmed and now " + ride.getPartner().getName() + " is coming at the pickup location.");
    }
}
