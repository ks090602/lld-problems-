package com.example.fooddelivery.strategy;

public class UPI implements Payment{
    public boolean pay(double amount)
    {
        System.out.println("Amount paid using UPI");
        return true;
    }
}
