package com.example.ridesharing.strategy.paymentstrategy;

import com.example.ridesharing.model.Ride;

public class Card implements PaymentStrategy{
    @Override
    public boolean pay(Ride ride)
    {
        System.out.println("Amount paid using Card: " + ride.getFare());
        return true;
    }
}
