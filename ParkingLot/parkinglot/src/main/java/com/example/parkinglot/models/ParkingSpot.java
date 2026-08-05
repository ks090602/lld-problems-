package com.example.parkinglot.models;

import java.util.concurrent.atomic.AtomicBoolean;

import com.example.parkinglot.enums.VehicleType;

public class ParkingSpot {
    private static int autoID = 1;
    private int id;
    private VehicleType vehicleType;
    private AtomicBoolean isAvailable;
    private int vehicleNum; 
    
    public ParkingSpot(VehicleType vehicleType)
    {
        id = autoID++;
        isAvailable = new AtomicBoolean(true);
        this.vehicleType = vehicleType;
        vehicleNum = 0;
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getVehicleNumber() {
        return vehicleNum;
    }
    public boolean isAvailable() {
        return isAvailable.get();
    }

    public void setAvailability(boolean newValue)
    {
        isAvailable.set(newValue);
    }

    public void parkVehicle(Vehicle vehicle)
    {
        setAvailability(false);
        this.vehicleNum = vehicle.getVehicleNumber();
    }

    public void unParkVehicle()
    {
        setAvailability(true);
        this.vehicleNum = 0;
    }
}
