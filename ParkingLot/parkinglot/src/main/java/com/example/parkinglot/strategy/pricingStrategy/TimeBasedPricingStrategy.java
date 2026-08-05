package com.example.parkinglot.strategy.pricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.parkinglot.enums.VehicleType;

public class TimeBasedPricingStrategy implements PricingStrategy{
    private final Map<VehicleType,Double> Time_Based_Pricing_Map = new HashMap<>();
    public TimeBasedPricingStrategy(){ 
        Time_Based_Pricing_Map.put(VehicleType.CAR, 30.0);
        Time_Based_Pricing_Map.put(VehicleType.BIKE, 15.0);
        Time_Based_Pricing_Map.put(VehicleType.TRUCK, 50.0);
    }

    @Override
    public double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime, VehicleType vehicleType)
    {
        long hoursElapsed = Math.max(0, Duration.between(entryTime, exitTime).toHours());
        double rate = Time_Based_Pricing_Map.getOrDefault(vehicleType, 0.0);
        return (rate*hoursElapsed);
    }
}
