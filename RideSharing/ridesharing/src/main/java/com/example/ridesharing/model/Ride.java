package com.example.ridesharing.model;

import com.example.ridesharing.enums.RideStatus;

public class Ride {
    private final String id;
    private final User user;
    private final Partner partner;
    private final double fare;
    private final Address pickupLocation; 
    private Address dropLocation;
    private RideStatus rideStatus;
    public String getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Partner getPartner() {
        return partner;
    }
    public double getFare() {
        return fare;
    }
    public Address getPickupLocation() {
        return pickupLocation;
    }
    public Address getDropLocation() {
        return dropLocation;
    }
    public RideStatus getRideStatus() {
        return rideStatus;
    }
    public Ride(String id, User user, Partner partner, double fare, Address pickupLocation, Address dropLocation) {
        this.id = id;
        this.user = user;
        this.partner = partner;
        this.fare = fare;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        // since I will only be creating a ride object once partner accepted so this will be accepted on creation of the object 
        this.rideStatus = RideStatus.ACCEPTED;
    }

    public void setRideStatusCompleted()
    {
        this.rideStatus = RideStatus.COMPLETED;
    }
    

    public void setRideStatusCancelled()
    {
        this.rideStatus = RideStatus.CANCELLED;
    }
    

    public void setRideStatusInProgress()
    {
        this.rideStatus = RideStatus.IN_PROGRESS;
    }
    
    
}
