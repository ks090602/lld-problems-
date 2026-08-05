package com.example.ridesharing.strategy.driverassignmentstrategy;

import java.util.List;
import java.util.Optional;

import com.example.ridesharing.dto.RideRequest;
import com.example.ridesharing.model.Partner;

public class NearestStrategy implements DriverAssignStrategy{
    
    @Override
    public Partner getPartner(List<Partner> allAvailablePartners, RideRequest rideRequest)
    {
        Optional<Partner> partner = allAvailablePartners.stream()
            .min((p1, p2) -> Double.compare(
                p1.getLocation().distanceTo(rideRequest.getPickUp()),
                p2.getLocation().distanceTo(rideRequest.getPickUp())
            ));
        return partner.orElse(null);
    }
}
