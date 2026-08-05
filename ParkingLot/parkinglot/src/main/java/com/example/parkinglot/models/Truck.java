package com.example.parkinglot.models;

import com.example.parkinglot.enums.VehicleType;

public class Truck extends Vehicle{
    public Truck(int number)
    {
        super(number);
    }

    @Override
    public VehicleType getType()
    {
        return VehicleType.TRUCK;
    }
}
