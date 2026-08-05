package com.example.parkinglot.strategy.pricingStrategy;

import java.time.LocalDateTime;

import com.example.parkinglot.enums.VehicleType;

public interface PricingStrategy {
    double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime, VehicleType vehicleType); 
}
