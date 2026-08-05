package com.example.paymentgateway.repo.paymentrepo;

import java.util.List;
import java.util.Optional;

import com.example.paymentgateway.enums.Status;
import com.example.paymentgateway.model.Payment;
import com.example.paymentgateway.repo.IRepo;

public interface PaymentRepo extends IRepo<Payment, Integer>{
    List<Payment> getAllPayments();
    List<Payment> getPaymentByStatus(Status s);
    Optional<Payment> getByIdempotencyKey(String key);
}
