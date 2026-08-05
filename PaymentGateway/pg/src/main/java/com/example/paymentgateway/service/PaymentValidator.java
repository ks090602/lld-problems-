package com.example.paymentgateway.service;

import com.example.paymentgateway.dto.PaymentRequest;
import com.example.paymentgateway.repo.merchantrepo.MerchantRepo;

public class PaymentValidator {
    private final MerchantRepo merchantRepo;
    public PaymentValidator(MerchantRepo merchantRepo)
    {
        this.merchantRepo = merchantRepo;
    }

    public void validate(PaymentRequest paymentRequest)
    {
        if(paymentRequest.getAmount()<=0){
            throw new IllegalArgumentException("Amount should always be positive");
        }
        if(paymentRequest.getCurrency()==null)
        {
            throw new IllegalArgumentException("Currency Cannot be null");
        }
        if(paymentRequest.getIdempotencyKey().isBlank())
        {
            throw new IllegalArgumentException("Idempotency Key shouldn't be empty");
        }
        if(merchantRepo.getById(paymentRequest.getMerchantId())==null)
        {
            throw new IllegalArgumentException("Invalid Merchant Id");
        }
        if(paymentRequest.getPaymentMethod()==null)
        {
            throw new IllegalArgumentException("Payment Method cannot be null");
        }
        if(paymentRequest.getSender().isBlank())
        {
            throw new IllegalArgumentException("Sender must be valid, Here its invalid sender");
        }
    }
}
