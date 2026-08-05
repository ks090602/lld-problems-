package com.example.fooddelivery.strategy;

public class COD implements Payment{
    public boolean pay(double amount)
    {
        System.out.println("Amount will be paid using Cash On Delivery");
        return true;
    }
}
