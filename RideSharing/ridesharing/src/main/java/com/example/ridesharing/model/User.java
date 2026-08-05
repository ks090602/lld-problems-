package com.example.ridesharing.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    public String getId() {
        return id;
    }

    private String name;
    private Address address;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private double rating;
    private final List<Ride> rideHistory;

    public Double getRating() {
        return rating;
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }

    public User(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = 0;
        this.rideHistory = new ArrayList<>();
    }

    public void updateRating(Double newRating)
    {
        // averaging out the rating
        rating = (double)((rideHistory.size()-1)*rating + newRating)/rideHistory.size();
    }

    public void addRide(Ride r)
    {
        rideHistory.add(r);
    }

    
    
    
}
