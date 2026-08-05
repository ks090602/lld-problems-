package com.example.ridesharing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ridesharing.enums.PricingStrategyType;
import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.factory.PricingFactory;
import com.example.ridesharing.model.Address;
import com.example.ridesharing.model.Vehicle;

public class PricingService {
    private final PricingFactory pricingFactory;
    public PricingService(PricingFactory pricingFactory)
    {
        this.pricingFactory = pricingFactory;
    }    

    public Map<VehicleType,Double> getPrice(PricingStrategyType pricingStrategyType,Address pickup,Address drop,List<Vehicle> allVehicles)
    {
        Map<VehicleType,Double> baseFares = new HashMap<>();
        allVehicles.forEach(v->baseFares.put(v.getVehicleType(), v.getBaseRatePerKm()));

        return pricingFactory.getPricingStrategy(pricingStrategyType).getPrice(pickup, drop, baseFares); 
    }
}
