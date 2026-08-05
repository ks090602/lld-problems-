package com.example.paymentgateway.repo.merchantrepo;

import java.util.List;

import com.example.paymentgateway.model.Merchant;
import com.example.paymentgateway.repo.IRepo;

public interface MerchantRepo extends IRepo<Merchant, String>{
    List<Merchant> getAllMerchants();
}
