package com.example.paymentgateway.service;

import com.example.paymentgateway.enums.RetryMechnaismType;
import com.example.paymentgateway.factory.PaymentFactory;
import com.example.paymentgateway.factory.RetryMechanismFactory;
import com.example.paymentgateway.model.Payment;
import com.example.paymentgateway.model.Transaction;
import com.example.paymentgateway.strategy.paymentstrategies.PaymentStrategy;
import com.example.paymentgateway.strategy.retrymechanismstrategy.RetryMechanismStrategy;

public class PaymentProcessor {

    private static final int MAX_RETRIES = 3;

    private final PaymentFactory paymentFactory;
    private final RetryMechanismFactory retryMechanismFactory;
    private final TransactionService transactionService;

    public PaymentProcessor(
            PaymentFactory paymentFactory,
            RetryMechanismFactory retryMechanismFactory,
            TransactionService transactionService) {

        this.paymentFactory = paymentFactory;
        this.retryMechanismFactory = retryMechanismFactory;
        this.transactionService = transactionService;
    }

    public void pay(Payment payment) throws Exception {

        PaymentStrategy paymentStrategy =
                paymentFactory.getPaymentStrategy(payment.getPaymentMethod());

        RetryMechanismStrategy retryStrategy =
                retryMechanismFactory.getRetryMechanismStrategy(
                        RetryMechnaismType.LOOPBASED);

        int attemptNumber = 1;

        boolean paymentSuccessful = retryStrategy.retryPayment(() -> {

            Transaction transaction =
                    transactionService.createNewTransaction(attemptNumber, payment.getPaymentMethod());

            payment.addTransaction(transaction);

            transaction.statusProcessing();
            transactionService.saveTransaction(transaction);

            boolean success = paymentStrategy.pay(transaction);

            if (success) {
                transaction.statusSuccessful();
            } else {
                transaction.statusFailed();
            }

            transactionService.saveTransaction(transaction);

            return success;

        }, MAX_RETRIES);

        if (paymentSuccessful) {
            payment.statusSuccessful();
        } else {
            payment.statusFailed();
            throw new Exception("Payment failed after all retry attempts.");
        }
    }
}