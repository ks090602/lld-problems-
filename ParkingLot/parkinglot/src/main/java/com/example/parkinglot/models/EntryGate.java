package com.example.parkinglot.models;

import java.time.LocalDateTime;

import com.example.parkinglot.service.ParkingLot;

public class EntryGate extends Gate{

    public EntryGate(int id){
        super(id);
    }

    @Override
    public String getType()
    {
        return "ENTRY";
    }

    public Ticket parkVehicle(Vehicle vehicle,LocalDateTime entryTime)
    {
        return ParkingLot.getInstance().parkVehicle(vehicle,entryTime);
    }

    public int getId()
    {
        return id;
    }
}
