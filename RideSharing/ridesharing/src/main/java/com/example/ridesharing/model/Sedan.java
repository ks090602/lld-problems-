package com.example.ridesharing.model;

import com.example.ridesharing.enums.VehicleType;

public class Sedan extends Vehicle{
    public Sedan(String vehicleNumber)
    {
        super(vehicleNumber, VehicleType.SEDAN, 30);
    }
}
