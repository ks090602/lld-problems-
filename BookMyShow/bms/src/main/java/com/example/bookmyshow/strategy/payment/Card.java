package com.example.bookmyshow.strategy.payment;

public class Card implements Payment{
    @Override
    public boolean pay(double amount)
    {
        System.out.println("Payment Done By Card");
        return true;
    }
}
