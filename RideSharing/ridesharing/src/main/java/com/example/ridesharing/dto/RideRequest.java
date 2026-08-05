package com.example.ridesharing.dto;

import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.model.Address;
import com.example.ridesharing.model.User;

public class RideRequest {
    private final User user;
    private final Address pickUp;
    private final Address drop;
    private final VehicleType requestedVehicleType;
    private final double fare;
    public RideRequest(User user, Address pickUp, Address drop, VehicleType requestedVehicleType, double fare) {
        this.user = user;
        this.pickUp = pickUp;
        this.drop = drop;
        this.requestedVehicleType = requestedVehicleType;
        this.fare = fare;
    }
    public User getUser() {
        return user;
    }
    public Address getPickUp() {
        return pickUp;
    }
    public Address getDrop() {
        return drop;
    }
    public VehicleType getRequestedVehicleType() {
        return requestedVehicleType;
    }
    public double getFare() {
        return fare;
    }


}
