package com.example.fooddelivery.service;

import com.example.fooddelivery.enums.PaymentMethod;
import com.example.fooddelivery.factory.PaymentFactory;
import com.example.fooddelivery.strategy.Payment;

public class PaymentProcessor {
    private final PaymentFactory paymentFactory = new PaymentFactory(); 
    public boolean pay(double amount,PaymentMethod paymentMethod)
    {
        Payment payment = paymentFactory.getPaymentMethod(paymentMethod);
        return payment.pay(amount);
    }
}
