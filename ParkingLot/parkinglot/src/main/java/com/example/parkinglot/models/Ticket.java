package com.example.parkinglot.models;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.parkinglot.enums.VehicleType;

public class Ticket {
    private static AtomicInteger autoID = new AtomicInteger(0);
    private int id;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private int floorID; 
    private int spotID;

    public Ticket(Vehicle vehicle, LocalDateTime entryTime, int floorID, int spotID)
    {
        id = autoID.incrementAndGet();
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.floorID = floorID;
        this.spotID = spotID;
        this.vehicleType = vehicle.getType();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getFloorID() {
        return floorID;
    }

    public int getSpotID() {
        return spotID;
    }


}
