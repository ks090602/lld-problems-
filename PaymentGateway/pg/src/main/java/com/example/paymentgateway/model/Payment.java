package com.example.paymentgateway.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.paymentgateway.enums.Currency;
import com.example.paymentgateway.enums.PaymentMethod;
import com.example.paymentgateway.enums.Status;

public class Payment {
    private static final AtomicInteger autoId = new AtomicInteger(0);
    private final int id;
    private final double amount;
    private final String sender;
    private final Currency currency;
    private final String merchantId;
    private final PaymentMethod paymentMethod;
    private Status status;
    private final LocalDateTime createdAt;
    private final List<Transaction> transactions;
    private final String idempotencyKey;

    public Payment(double amount,String sender, Currency currency, String merchantId, PaymentMethod paymentMethod, String idempotencyKey) {
        this.sender = sender;
        this.amount = amount;
        this.currency = currency;
        this.merchantId = merchantId;
        this.paymentMethod = paymentMethod;
        this.idempotencyKey = idempotencyKey;
        this.id = autoId.incrementAndGet();
        this.status = Status.CREATED;
        this.createdAt = LocalDateTime.now();
        this.transactions = new ArrayList<>();
    }

    public double getAmount(){
        return amount;
    }
    public int getId() {
        return id;
    }
    public String getSender() {
        return sender;
    }
    public Currency getCurrency() {
        return currency;
    }
    public String getMerchantId() {
        return merchantId;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public String getIdempotencyKey() {
        return idempotencyKey;
    } 
    public void addTransaction(Transaction t)
    {
        transactions.add(t);
    }

}
