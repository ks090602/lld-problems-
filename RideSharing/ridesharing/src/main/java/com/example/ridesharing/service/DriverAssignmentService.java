package com.example.ridesharing.service;

import java.util.List;

import com.example.ridesharing.dto.RideRequest;
import com.example.ridesharing.enums.DriverAssignmentStrategyType;
import com.example.ridesharing.factory.DriverAssignmentFactory;
import com.example.ridesharing.model.Partner;

public class DriverAssignmentService {
    private final DriverAssignmentFactory driverAssignmentFactory;
    public DriverAssignmentService(DriverAssignmentFactory driverAssignmentFactory)
    {
        this.driverAssignmentFactory = driverAssignmentFactory;
    }

    public Partner getPartner(RideRequest rideRequest,List<Partner> allAvailablePartners,DriverAssignmentStrategyType driverAssignmentStrategyType)
    {
        return driverAssignmentFactory.getDriverAssignmentStrategy(driverAssignmentStrategyType).getPartner(allAvailablePartners, rideRequest);
    }
}
