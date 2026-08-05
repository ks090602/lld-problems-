package com.example.fooddelivery.strategy;


public class Card implements Payment{
    public boolean pay(double amount)
    {
        System.out.println("Amount paid using Card");
        return true;
    }
}