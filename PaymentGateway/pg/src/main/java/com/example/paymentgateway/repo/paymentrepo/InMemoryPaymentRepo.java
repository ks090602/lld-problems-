package com.example.paymentgateway.repo.paymentrepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.example.paymentgateway.enums.Status;
import com.example.paymentgateway.model.Payment;

public class InMemoryPaymentRepo implements PaymentRepo{
    private final Map<Integer, Payment> payments;
    public InMemoryPaymentRepo()
    {
        payments = new ConcurrentHashMap<>();
    }

    @Override 
    public void save(Payment p)
    {
        payments.put(p.getId(), p);
    }

    @Override
    public Payment getById(Integer id)
    {
        return payments.get(id);
    }

    @Override 
    public void remove(Integer id)
    {
        payments.remove(id);
    }

    @Override
    public List<Payment> getAllPayments()
    {
        return new ArrayList<>(payments.values());
    }

    @Override
    public List<Payment> getPaymentByStatus(Status status)
    {
        return payments.values().stream().filter(p->p.getStatus()==status).collect(Collectors.toList());
    }

    public Optional<Payment> getByIdempotencyKey(String idempotencyKey)
    {
        return payments.values().stream().filter(p->p.getIdempotencyKey()==idempotencyKey).findFirst();
    }
}
