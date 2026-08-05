package com.example.parkinglot.factory;

import com.example.parkinglot.enums.VehicleType;
import com.example.parkinglot.models.Bike;
import com.example.parkinglot.models.Car;
import com.example.parkinglot.models.Truck;
import com.example.parkinglot.models.Vehicle;

public class VehicleFactory {
    public Vehicle getVehicle(VehicleType vehicleType,int vehicleNumber)
    {
        switch (vehicleType) {
            case CAR:
                return new Car(vehicleNumber);
            case BIKE:
                return new Bike(vehicleNumber);
            case TRUCK:
                return new Truck(vehicleNumber);
            default:
                break;
        }
        return null;
    }
}
