package com.example.paymentgateway.repo.merchantrepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.paymentgateway.model.Merchant;

public class InMemoryMerchantRepo implements MerchantRepo{
    private final Map<String, Merchant> merchants; 

    public InMemoryMerchantRepo()
    {
        // since there can be concurrent Modifictations like remove and get which can lead to an illegal state so to avoid that we can use ConcurrentHashMap
        merchants = new ConcurrentHashMap<>();
    }

    @Override
    public void save(Merchant merchant)
    {
        merchants.put(merchant.getMerchantId(), merchant);
    }

    @Override 
    public Merchant getById(String merchantId)
    {
        return merchants.get(merchantId);
    }

    @Override
    public void remove(String merchantId)
    {
        merchants.remove(merchantId);
    }

    @Override
    public List<Merchant> getAllMerchants()
    {
        return new ArrayList<>(merchants.values());
    }

}
