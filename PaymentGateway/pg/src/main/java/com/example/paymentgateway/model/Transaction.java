package com.example.paymentgateway.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.paymentgateway.enums.PaymentMethod;
import com.example.paymentgateway.enums.Status;

public class Transaction {
    private static final AtomicInteger autoId = new AtomicInteger(0); 
    private final int id;
    private final int attemptNumber;
    private final LocalDateTime processedAt;
    private Status status;
    private String failureReason;

    public Transaction(int attemptNumber, 
            PaymentMethod paymentMethod) {
        this.id = autoId.incrementAndGet();
        this.attemptNumber = attemptNumber;
        this.processedAt = LocalDateTime.now();
        this.status = Status.CREATED;
        this.failureReason = "";
    }
    public int getId() {
        return id;
    }
    public int getAttemptNumber() {
        return attemptNumber;
    }
    public LocalDateTime getProcessedAt() {
        return processedAt;
    }
    public Status getStatus() {
        return status;
    }
    public void statusProcessing()
    {
        this.status = Status.PROCESSING;
    }
    public void statusFailed()
    {
        this.status = Status.FAILED;
    }
    public void statusSuccessful()
    {
        this.status = Status.SUCCESSFUL;
    }

    public String getFailureReason() {
        return failureReason;
    }
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

}
