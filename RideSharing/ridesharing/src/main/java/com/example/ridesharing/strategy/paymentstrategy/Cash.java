package com.example.ridesharing.strategy.paymentstrategy;

import com.example.ridesharing.model.Ride;

public class Cash implements PaymentStrategy{
    @Override
    public boolean pay(Ride ride)
    {
        System.out.println("Amount paid using Cash: " + ride.getFare());
        return true;
    }
}
