package com.example.paymentgateway.factory;

import java.util.HashMap;
import java.util.Map;

import com.example.paymentgateway.enums.PaymentMethod;
import com.example.paymentgateway.strategy.paymentstrategies.CardStrategy;
import com.example.paymentgateway.strategy.paymentstrategies.NetBankingStrategy;
import com.example.paymentgateway.strategy.paymentstrategies.PaymentStrategy;
import com.example.paymentgateway.strategy.paymentstrategies.UPIStrategy;

public class PaymentFactory {
    private final Map<PaymentMethod,PaymentStrategy> mappings;

    public PaymentFactory(){
        mappings = new HashMap<>();
        mappings.put(PaymentMethod.CARD, new CardStrategy());
        mappings.put(PaymentMethod.UPI, new UPIStrategy());
        mappings.put(PaymentMethod.NET_BANKING, new NetBankingStrategy());
    }

    public PaymentStrategy getPaymentStrategy(PaymentMethod paymentMethod)
    {
        return mappings.get(paymentMethod);
    }
}
