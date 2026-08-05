package com.example.fooddelivery.factory;

import java.util.EnumMap;
import java.util.Map;

import com.example.fooddelivery.enums.PaymentMethod;
import com.example.fooddelivery.strategy.COD;
import com.example.fooddelivery.strategy.Card;
import com.example.fooddelivery.strategy.Payment;
import com.example.fooddelivery.strategy.UPI;

public class PaymentFactory {
    private final Map<PaymentMethod,Payment> paymentObjects = new EnumMap<>(PaymentMethod.class);

    public PaymentFactory()
    {
        paymentObjects.put(PaymentMethod.CARD, new Card());
        paymentObjects.put(PaymentMethod.UPI, new UPI());
        paymentObjects.put(PaymentMethod.COD, new COD());
    }

    public Payment getPaymentMethod(PaymentMethod paymentMethod)
    {
        Payment paymentStrategy = paymentObjects.get(paymentMethod);
        if(paymentStrategy == null){
            throw new IllegalArgumentException("Unsupported payment method");
        }
        return paymentStrategy;
    }
}
