package com.example.ridesharing.model;

public class Address {
    private final double latitude;
    private final double longitude;

    public Address(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double distanceTo(Address a)
    {
        // replicating just an demo for distance calculations between two addresses
        return Math.abs(a.latitude-this.latitude)+Math.abs(a.longitude-this.longitude);
    }

    
}
