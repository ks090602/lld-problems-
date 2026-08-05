package com.example.ridesharing.model;

import com.example.ridesharing.enums.PartnerStatus;

public class Partner {
    private final String id;
    public String getId() {
        return id;
    }
    private String name;
    private Vehicle vehicle;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    private Integer totalRides;
    public Integer getTotalRides() {
        return totalRides;
    }
    private double rating;
    private PartnerStatus partnerStatus;
    private Address location;
    public Address getLocation() {
        return location;
    }
    public void setLocation(Address location) {
        this.location = location;
    }
    public double getRating() {
        return rating;
    }
    public PartnerStatus getPartnerStatus() {
        return partnerStatus;
    }
    public Partner(String id, String name, Vehicle vehicle, Address location) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.partnerStatus = PartnerStatus.AVAILABLE;
        this.rating = 0;
        this.totalRides = 0;
        this.location = location;
    }

    public void setPartnerStatusAvailable()
    {
        this.partnerStatus = PartnerStatus.AVAILABLE;
    }

    public void setPartnerStatusUnAvailable()
    {
        this.partnerStatus = PartnerStatus.UNAVAILABLE;
    }

    public void setPartnerStatusOnRide()
    {
        this.partnerStatus = PartnerStatus.ON_RIDE;
    }

    public void addRideCount()
    {
        this.totalRides+=1;
    }
    
    public void updateRating(double rating)
    {
        // averaging out the rating
        this.rating = (double)((totalRides-1)*this.rating + rating)/totalRides;
    }

    

}
