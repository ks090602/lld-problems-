package com.example.paymentgateway.strategy.retrymechanismstrategy;

import java.util.function.Supplier;

public abstract class RetryMechanismStrategy {
    public abstract boolean retryPayment(Supplier<Boolean> action,int retryCount);
}
