package com.example.bookmyshow.factory;

import com.example.bookmyshow.enums.PaymentStrategyType;
import com.example.bookmyshow.strategy.payment.Card;
import com.example.bookmyshow.strategy.payment.Payment;
import com.example.bookmyshow.strategy.payment.UPI;

public class PaymentFactory {
    public static Payment getPaymentStrategy(PaymentStrategyType type)
    {
        switch (type)
        {
            case UPI:
                return new UPI();
            case CARD:
                return new Card();
            default:
                return new UPI();
        }
    } 
}
