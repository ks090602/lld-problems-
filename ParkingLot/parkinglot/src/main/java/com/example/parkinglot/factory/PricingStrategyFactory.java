package com.example.parkinglot.factory;

import com.example.parkinglot.strategy.pricingStrategy.EventBasedPricingStrategy;
import com.example.parkinglot.strategy.pricingStrategy.PricingStrategy;
import com.example.parkinglot.strategy.pricingStrategy.TimeBasedPricingStrategy;

public class PricingStrategyFactory {
    public static PricingStrategy getStrategy(String type)
    {
        switch (type) {
            case "TIME":
                return new TimeBasedPricingStrategy(); 
            case "EVENT":
                return new EventBasedPricingStrategy();
            default:
                break;
        }
        return null;
    }
}
