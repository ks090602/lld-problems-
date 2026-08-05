package com.example.parkinglot.models;

import com.example.parkinglot.enums.VehicleType;

public class Car extends Vehicle{
    public Car(int number)
    {
        super(number);
    }

    @Override
    public VehicleType getType()
    {
        return VehicleType.CAR;
    }

}
