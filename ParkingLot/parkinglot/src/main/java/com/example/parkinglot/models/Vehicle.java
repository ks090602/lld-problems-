package com.example.parkinglot.models;

import com.example.parkinglot.enums.VehicleType;

public abstract class Vehicle {
    protected int vehicleNum;
    
    public Vehicle(int vehicleNum)
    {
        this.vehicleNum = vehicleNum;
    }
    protected abstract VehicleType getType();
    public int getVehicleNumber(){
        return vehicleNum;
    }
}
