package com.example.parkinglot.service;

import com.example.parkinglot.factory.PaymentStrategyFactory;

public class PaymentProcessor {    
    public static void pay(double amount, String paymentMode) {
        try{
            PaymentStrategyFactory.getPaymentStrategy(paymentMode).payAmount(amount);
        } 
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
}
