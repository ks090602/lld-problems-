package com.example.paymentgateway.model;


public class Merchant {
    private final String merchantId;
    private final String merchantName;
    public Merchant(String merchantId, String merchantName) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
    }
    public String getMerchantId() {
        return merchantId;
    }
    public String getMerchantName() {
        return merchantName;
    }
}   
