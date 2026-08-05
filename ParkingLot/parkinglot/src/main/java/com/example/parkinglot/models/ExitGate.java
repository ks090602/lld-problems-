package com.example.parkinglot.models;

import java.time.LocalDateTime;

import com.example.parkinglot.service.ParkingLot;

public class ExitGate extends Gate{

    public ExitGate(int id){
        super(id);
    }

    @Override
    public String getType()
    {
        return "EXIT";
    }

    public void unParkVehicle(Ticket ticket,LocalDateTime exitTime,String paymentMode)
    {
        ParkingLot.getInstance().unParkVehicle(ticket,exitTime,paymentMode);
    }

    public int getId()
    {
        return id;
    }
}
