package com.example.parkinglot.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.parkinglot.factory.PricingStrategyFactory;
import com.example.parkinglot.models.ParkingFloor;
import com.example.parkinglot.models.ParkingSpot;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.strategy.pricingStrategy.PricingStrategy;

public class ParkingLot {
    private static final ParkingLot instance = new ParkingLot();
    private ParkingLot(){}
    public static ParkingLot getInstance(){
        return instance;
    }

    private final Map<Integer,ParkingFloor> parkingFloors = new HashMap<>();
    private final Map<Integer,Ticket> activeTickets = new HashMap<>();
    private PricingStrategy pricingStrategy;
    
    public void setPricingStrategy(String type)
    {
        this.pricingStrategy = PricingStrategyFactory.getStrategy(type);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime)
    {
        if (vehicle == null || entryTime == null || parkingFloors == null || parkingFloors.isEmpty()) {
            return null;
        }

        for (ParkingFloor floor : parkingFloors.values()) {
            if (floor != null) {
                ParkingSpot spot = floor.parkVehicle(vehicle);
                if(spot == null) continue;
                Ticket ticket = new Ticket(vehicle, entryTime, floor.getId(),spot.getId());
                activeTickets.put(ticket.getId(), ticket);
                return ticket;
            }
        }

        return null;
    }

    public void unParkVehicle(Ticket ticket,LocalDateTime exitTime,String paymentMode)
    {
        double amountToPay = pricingStrategy.calculatePrice(ticket.getEntryTime(), exitTime, ticket.getVehicleType());
        PaymentProcessor.pay(amountToPay, paymentMode);
        parkingFloors.get(ticket.getFloorID()).unParkVehicle(ticket.getSpotID());
        activeTickets.remove(ticket.getId());
        ticket = null;
    }

    public void addFloor(ParkingFloor floor)
    {
        parkingFloors.put(floor.getId(), floor);
    }
}
