package com.example.ridesharing.strategy.driverassignmentstrategy;

import java.util.List;

import com.example.ridesharing.dto.RideRequest;
import com.example.ridesharing.model.Partner;

public interface DriverAssignStrategy {
    Partner getPartner(List<Partner> allAvailablePartners,RideRequest rideRequest);
}
