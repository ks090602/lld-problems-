package com.example.paymentgateway.factory;

import java.util.HashMap;
import java.util.Map;

import com.example.paymentgateway.enums.RetryMechnaismType;
import com.example.paymentgateway.strategy.retrymechanismstrategy.LoopBasedRetryStrategy;
import com.example.paymentgateway.strategy.retrymechanismstrategy.RetryMechanismStrategy;

public class RetryMechanismFactory {
    private final Map<RetryMechnaismType,RetryMechanismStrategy> mappings;
    public RetryMechanismFactory()
    {
        mappings = new HashMap<>();
        mappings.put(RetryMechnaismType.LOOPBASED, new LoopBasedRetryStrategy());
    }
    
    public RetryMechanismStrategy getRetryMechanismStrategy(RetryMechnaismType retrymech)
    {
        return mappings.get(retrymech);
    }
}
