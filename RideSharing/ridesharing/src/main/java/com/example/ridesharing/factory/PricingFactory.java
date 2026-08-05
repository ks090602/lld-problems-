package com.example.ridesharing.factory;

import java.util.EnumMap;
import java.util.Map;

import com.example.ridesharing.enums.PricingStrategyType;
import com.example.ridesharing.strategy.pricingstrategy.NightPricingStrategy;
import com.example.ridesharing.strategy.pricingstrategy.NormalDayPricingStrategy;
import com.example.ridesharing.strategy.pricingstrategy.PricingStrategy;

public class PricingFactory {
    private Map<PricingStrategyType,PricingStrategy> objects;
    
    public PricingFactory()
    {
        this.objects = new EnumMap<>(PricingStrategyType.class);
        objects.put(PricingStrategyType.NIGHT_BASED, new NightPricingStrategy());
        objects.put(PricingStrategyType.NORMAL_DAY_PRICING_STRATEGY, new NormalDayPricingStrategy());
    }

    public PricingStrategy getPricingStrategy(PricingStrategyType pt)
    {
        return objects.get(pt);
    }
}
