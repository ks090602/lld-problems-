package com.example.ridesharing.service;

import com.example.ridesharing.enums.PaymentType;
import com.example.ridesharing.factory.PaymentFactory;
import com.example.ridesharing.model.Ride;

public class PaymentProcessor {
    private final PaymentFactory paymentFactory;
    public PaymentProcessor(PaymentFactory paymentFactory){
        this.paymentFactory = paymentFactory;
    }

    public boolean pay(PaymentType pt,Ride ride)
    {
        return paymentFactory.getPaymentStrategy(pt).pay(ride);
    }
}
