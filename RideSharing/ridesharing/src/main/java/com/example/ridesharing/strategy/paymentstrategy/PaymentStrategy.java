package com.example.ridesharing.strategy.paymentstrategy;

import com.example.ridesharing.model.Ride;

public interface PaymentStrategy {
    boolean pay(Ride r);
}
