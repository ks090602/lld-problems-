package com.example.parkinglot;

import java.time.LocalDateTime;

import com.example.parkinglot.enums.VehicleType;
import com.example.parkinglot.factory.VehicleFactory;
import com.example.parkinglot.models.EntryGate;
import com.example.parkinglot.models.ExitGate;
import com.example.parkinglot.models.ParkingFloor;
import com.example.parkinglot.models.ParkingSpot;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.service.ParkingLot;

/*

Requirements -
Extensible
1) The system should be extesnible to support different vehicle types
2) A parking Spot will accomodate a specific Vehicle type 
3) multiple pricing strategies 
4) multiple payment methods

Dynamic -
1) dynamic spots and floors 
2) multiple entry and exit gate - ticket is generated at entry gate and used to caculate price at exit gate 

Concurrency - 
1) Ensure that no two vehicles get the same Parking Spot 


Entities - 
1) Vehicle 
2) ParkingSpot
3) ParkingFloor
4) ParkingLot
5) Gate
6) Ticket
7) Payment (Strategy Design Pattern)
8) Price (Strategy Design Pattern)



To think of UML and its methods quickly think of a happy flow that happens 

Vehicle comes to a Entry gate(parkVehicle(Vehicle,entryTime)) -> calls ParkVehicle method of ParkingLot -> calls findAvailableSpot() for all floors which is method of ParkingFloor -> calls isSpotAvaialable() of ParkingSpot   

Ticket -> id,entryTime,exitTime,vehicleNum,parkingSpotId

Vehicle comes to Exit Gate (unparkVehicle(Ticket,exitTime,PaymentMethod)) -> calls unparkVehicle() method of ParkingLot -> set isAvailable of parkingSpot to true -> call pricingStrategy and PaymentStrategy


*/


public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.setPricingStrategy("EVENT");

        ParkingFloor floor1 = new ParkingFloor();
        floor1.addSpot(new ParkingSpot(VehicleType.CAR));
        floor1.addSpot(new ParkingSpot(VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot(VehicleType.CAR));
        floor1.addSpot(new ParkingSpot(VehicleType.TRUCK));

        ParkingFloor floor2 = new ParkingFloor();
        floor2.addSpot(new ParkingSpot(VehicleType.CAR));
        
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        VehicleFactory vehicleFactory = new VehicleFactory();
        // Vehicle truck1 = vehicleFactory.getVehicle(VehicleType.TRUCK, 7654);
        // Vehicle truck2 = vehicleFactory.getVehicle(VehicleType.TRUCK, 4392);

        Vehicle car1 = vehicleFactory.getVehicle(VehicleType.CAR, 9354);
        Vehicle car2 = vehicleFactory.getVehicle(VehicleType.CAR, 1245);
        Vehicle car3 = vehicleFactory.getVehicle(VehicleType.CAR, 7365);
        Vehicle car4 = vehicleFactory.getVehicle(VehicleType.CAR, 2359);

        LocalDateTime entryTime = LocalDateTime.now();
        LocalDateTime exitTime = entryTime.plusHours(2);

        EntryGate entryGate1 = new EntryGate(1);
        EntryGate entryGate2 = new EntryGate(2);
        ExitGate exitGate1 = new ExitGate(1);
        
        Thread t1 = new Thread(()->{
            Ticket t = entryGate1.parkVehicle(car1, entryTime);
            if(t==null) System.out.println("Ticket is null,Vehicle can't be parked said by " + Thread.currentThread().getName());
            else System.out.println("Your Ticket id is: " + t.getId() + " said by " + Thread.currentThread().getName());
            exitGate1.unParkVehicle(t, exitTime, "UPI");
        });
        Thread t2 = new Thread(()->{
            Ticket t = entryGate2.parkVehicle(car2, entryTime);
            if(t==null) System.out.println("Ticket is null,Vehicle can't be parked said by " + Thread.currentThread().getName());
            else System.out.println("Your Ticket id is: " + t.getId() + " said by " + Thread.currentThread().getName());
            exitGate1.unParkVehicle(t, exitTime.plusMinutes(66), "UPI");
        });
        Thread t3 = new Thread(()->{
            Ticket t = entryGate2.parkVehicle(car3, entryTime);
            if(t==null) System.out.println("Ticket is null,Vehicle can't be parked said by " + Thread.currentThread().getName());
            else System.out.println("Your Ticket id is: " + t.getId() + " said by " + Thread.currentThread().getName());
        });
        Thread t4 = new Thread(()->{
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            LocalDateTime entryTime2 = LocalDateTime.now();
            Ticket t = entryGate1.parkVehicle(car4, entryTime2);
            if(t==null) System.out.println("Ticket is null,Vehicle can't be parked said by " + Thread.currentThread().getName());
            else System.out.println("Your Ticket id is: " + t.getId() + " said by " + Thread.currentThread().getName());
        });
        Thread t5 = new Thread(()->{
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            LocalDateTime entryTime2 = LocalDateTime.now();
            Ticket t = entryGate1.parkVehicle(car1, entryTime2);
            if(t==null) System.out.println("Ticket is null,Vehicle can't be parked said by " + Thread.currentThread().getName());
            else System.out.println("Your Ticket id is: " + t.getId() + " said by " + Thread.currentThread().getName());
        });
        

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
}