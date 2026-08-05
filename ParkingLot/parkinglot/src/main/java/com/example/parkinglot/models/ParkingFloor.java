package com.example.parkinglot.models;

import java.util.ArrayList;
import java.util.List;


public class ParkingFloor {
    private static int autoID = 1;
    private int id;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(){
        id = autoID++;
        parkingSpots = new ArrayList<>();
    }

    public synchronized ParkingSpot parkVehicle(Vehicle vehicle)
    {
        if (vehicle.getType() == null || parkingSpots == null) {
            return null;
        }

        for (ParkingSpot spot : parkingSpots) {
            if (spot == null) {
                continue;
            }

            if (vehicle.getType().equals(spot.getVehicleType()) && spot.isAvailable()) {
                spot.parkVehicle(vehicle);
                return spot;
            }
        }

        return null;
    } 

    public synchronized void unParkVehicle(int parkingSpotId)
    {
        for(ParkingSpot spot:parkingSpots)
        {
            if(spot.getId()==parkingSpotId)
            {
                spot.unParkVehicle();
                break;
            }
        }
    }

    public void addSpot(ParkingSpot spot)
    {
        parkingSpots.add(spot);
    }

    public int getId(){
        return id;
    }
}
