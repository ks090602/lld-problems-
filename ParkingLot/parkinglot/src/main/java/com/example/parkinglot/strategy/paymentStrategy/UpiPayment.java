package com.example.parkinglot.strategy.paymentStrategy;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void payAmount(double amount)
    {
        System.out.println("Amount " + amount + " Paid via UPI");
    }
}
