package com.example.paymentgateway.dto;

import com.example.paymentgateway.enums.Currency;
import com.example.paymentgateway.enums.PaymentMethod;

public class PaymentRequest {
    private final String requestId;
    private final double amount;
    private final String sender;
    private final Currency currency;
    private final String merchantId;
    private final PaymentMethod paymentMethod;
    private final String idempotencyKey;

    public PaymentRequest(String id, double amount, String sender, Currency currency, String merchantId,PaymentMethod paymentMethod, String idempotencyKey) {
        this.requestId = id;
        this.amount = amount;
        this.sender = sender;
        this.currency = currency;
        this.merchantId = merchantId;
        this.paymentMethod = paymentMethod;
        this.idempotencyKey = idempotencyKey;
    }

    public String getId() {
        return requestId;
    }
    public double getAmount() {
        return amount;
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
    public String getIdempotencyKey() {
        return idempotencyKey;
    }


}
