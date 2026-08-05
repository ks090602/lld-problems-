package com.example.paymentgateway.strategy.retrymechanismstrategy;

import java.util.function.Supplier;

public class LoopBasedRetryStrategy extends RetryMechanismStrategy{
    @Override
    public boolean retryPayment(Supplier<Boolean> action,int retryCount){
        int count = 1;
        while(count<=retryCount)
        {
            System.out.println("Retrying payment for " + count + " time");
            if(action.get())
            {
                return true;
            }
            else 
            {
                count++;
            }
        }
        System.out.println("Payment Failed after all retries");
        return false;
    }
}