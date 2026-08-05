package com.example.ridesharing.strategy.pricingstrategy;

import java.util.HashMap;
import java.util.Map;

import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.model.Address;

public class NormalDayPricingStrategy implements PricingStrategy{
   
    @Override
    public Map<VehicleType,Double> getPrice(Address pickup,Address drop,Map<VehicleType,Double> baseFares)
    {
        Map<VehicleType,Double> newFares = new HashMap<>();
        baseFares.forEach((v,f)->{newFares.put(v, (double)f*pickup.distanceTo(drop));});
        return newFares;
    }
}
