package com.example.parkinglot.strategy.pricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.parkinglot.enums.VehicleType;

public class EventBasedPricingStrategy implements PricingStrategy{
    private final Map<VehicleType,Double> Event_Based_Pricing_Map = new HashMap<>();
    public EventBasedPricingStrategy(){ 
        Event_Based_Pricing_Map.put(VehicleType.CAR, 50.0);
        Event_Based_Pricing_Map.put(VehicleType.BIKE, 30.0);
        Event_Based_Pricing_Map.put(VehicleType.TRUCK, 80.0);
    }

    @Override
    public double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime, VehicleType vehicleType)
    {
        long hoursElapsed = Math.max(0, Duration.between(entryTime, exitTime).toHours());
        double rate = Event_Based_Pricing_Map.getOrDefault(vehicleType, 0.0);
        return (rate*hoursElapsed);
    }
}
