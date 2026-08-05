package com.example.parkinglot.factory;

import com.example.parkinglot.strategy.paymentStrategy.CashPayment;
import com.example.parkinglot.strategy.paymentStrategy.PaymentStrategy;
import com.example.parkinglot.strategy.paymentStrategy.UpiPayment;

public class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(String paymentMode)
    {
        switch (paymentMode) {
            case "UPI":
                return new UpiPayment();
            case "CASH":
                return new CashPayment();
            default:
                throw new IllegalArgumentException("Unsupported payment mode: " + paymentMode);
        }
    }
}
