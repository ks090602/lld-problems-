package com.example.ridesharing.strategy.paymentstrategy;

import com.example.ridesharing.model.Ride;

public class UPI implements PaymentStrategy{
    @Override
    public boolean pay(Ride ride)
    {
        System.out.println("Amount paid using UPI: " + ride.getFare());
        return true;
    }
}
