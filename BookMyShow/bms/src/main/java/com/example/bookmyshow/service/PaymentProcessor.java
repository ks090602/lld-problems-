package com.example.bookmyshow.service;

import com.example.bookmyshow.enums.PaymentStrategyType;
import com.example.bookmyshow.factory.PaymentFactory;
import com.example.bookmyshow.strategy.payment.Payment;

public class PaymentProcessor {
    public static boolean payAmount(PaymentStrategyType strategyType,double amount)
    {
        Payment payment = PaymentFactory.getPaymentStrategy(strategyType);
        return payment.pay(amount);
    }   
}
