package com.example.bookmyshow.strategy.payment;

public class UPI implements Payment{
    @Override
    public boolean pay(double amount)
    {
        System.out.println("Payment Done By UPI");
        return true;
    }
}
