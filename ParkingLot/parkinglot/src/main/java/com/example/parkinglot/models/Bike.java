package com.example.parkinglot.models;

import com.example.parkinglot.enums.VehicleType;

public class Bike extends Vehicle{
    public Bike(int number)
    {
        super(number);
    }

    @Override
    public VehicleType getType()
    {
        return VehicleType.BIKE;
    }
}
