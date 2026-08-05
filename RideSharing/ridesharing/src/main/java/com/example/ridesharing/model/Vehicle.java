package com.example.ridesharing.model;

import com.example.ridesharing.enums.VehicleType;

public abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private double baseRatePerKm;
    public void setBaseRatePerKm(double baseRatePerKm) {
        this.baseRatePerKm = baseRatePerKm;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public double getBaseRatePerKm() {
        return baseRatePerKm;
    }
    public Vehicle(String vehicleNumber, VehicleType vehicleType, double baseRatePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.baseRatePerKm = baseRatePerKm;
    }

    


}
