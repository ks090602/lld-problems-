package com.example.paymentgateway.strategy.paymentstrategies;

import com.example.paymentgateway.model.Transaction;

public class CardStrategy implements PaymentStrategy{
    public Boolean pay(Transaction transaction)
    {
        System.out.println("Trying payment through Card");
        return Math.random()<0.6;
    }
}
