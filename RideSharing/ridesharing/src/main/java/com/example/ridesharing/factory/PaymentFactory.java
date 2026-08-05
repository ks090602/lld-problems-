package com.example.ridesharing.factory;

import java.util.EnumMap;
import java.util.Map;

import com.example.ridesharing.enums.PaymentType;
import com.example.ridesharing.strategy.paymentstrategy.Card;
import com.example.ridesharing.strategy.paymentstrategy.Cash;
import com.example.ridesharing.strategy.paymentstrategy.PaymentStrategy;
import com.example.ridesharing.strategy.paymentstrategy.UPI;

public class PaymentFactory {
    private Map<PaymentType,PaymentStrategy> objects;
    
    public PaymentFactory()
    {
        objects = new EnumMap<>(PaymentType.class);
        objects.put(PaymentType.CARD, new Card());
        objects.put(PaymentType.CASH, new Cash());
        objects.put(PaymentType.UPI, new UPI());
    }

    public PaymentStrategy getPaymentStrategy(PaymentType pt)
    {
        return objects.get(pt);
    }
}
