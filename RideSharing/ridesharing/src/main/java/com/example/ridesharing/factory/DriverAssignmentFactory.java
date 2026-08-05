package com.example.ridesharing.factory;

import com.example.ridesharing.enums.DriverAssignmentStrategyType;
import com.example.ridesharing.strategy.driverassignmentstrategy.DriverAssignStrategy;
import com.example.ridesharing.strategy.driverassignmentstrategy.NearestStrategy;

import java.util.EnumMap;
import java.util.Map;

public class DriverAssignmentFactory {
    private Map<DriverAssignmentStrategyType, DriverAssignStrategy> objects;
    
    public DriverAssignmentFactory()
    {
        this.objects = new EnumMap<>(DriverAssignmentStrategyType.class);
        objects.put(DriverAssignmentStrategyType.NEAREST, new NearestStrategy());
    }

    public DriverAssignStrategy getDriverAssignmentStrategy(DriverAssignmentStrategyType type)
    {
        return objects.get(type);
    }
}
