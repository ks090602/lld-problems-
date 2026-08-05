package com.example.paymentgateway.strategy.paymentstrategies;


import com.example.paymentgateway.model.Transaction;

public interface PaymentStrategy {
    Boolean pay(Transaction transaction);
}
