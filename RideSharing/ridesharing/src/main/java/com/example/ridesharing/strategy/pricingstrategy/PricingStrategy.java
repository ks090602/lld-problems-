package com.example.ridesharing.strategy.pricingstrategy;

import java.util.Map;

import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.model.Address;

// we use this strategy to fetch all vehicleTypes fares to show on the display so that user can select one 
public interface PricingStrategy {
    Map<VehicleType,Double> getPrice(Address pickup,Address drop,Map<VehicleType,Double> baseFares);
}
