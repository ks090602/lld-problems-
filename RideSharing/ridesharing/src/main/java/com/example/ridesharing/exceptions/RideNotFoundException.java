package com.example.ridesharing.exceptions;

public class RideNotFoundException extends RuntimeException{
    public RideNotFoundException(String rideId)
    {
        super("No Such Ride Found with id: " + rideId);
    }
}
