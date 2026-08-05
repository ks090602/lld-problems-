package com.example.ridesharing.model;

import com.example.ridesharing.enums.VehicleType;

public class Auto extends Vehicle{
    public Auto(String vehicleNumber)
    {
        super(vehicleNumber, VehicleType.XUV, 20);
    }
}
