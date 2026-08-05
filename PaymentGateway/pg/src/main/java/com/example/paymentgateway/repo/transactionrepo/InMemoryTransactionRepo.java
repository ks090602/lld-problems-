package com.example.paymentgateway.repo.transactionrepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.example.paymentgateway.enums.Status;
import com.example.paymentgateway.model.Transaction;

public class InMemoryTransactionRepo implements TransactionRepo{
    private final Map<Integer, Transaction> transactions;
    public InMemoryTransactionRepo(){
        // since concurrent access and modifications can lead to an inconsistent state hashmap needs to be avoided and thus concurrenthashmap is the ideal choice 
        transactions = new ConcurrentHashMap<>();
    }

    @Override
    public void save(Transaction transaction){
        transactions.put(transaction.getId(), transaction);
    }

    @Override
    public Transaction getById(Integer id)
    {
        return transactions.get(id);
    }

    @Override
    public void remove(Integer id)
    {
        transactions.remove(id);
    }

    @Override
    public List<Transaction> getAllTransactions(){
        return new ArrayList<>(transactions.values());
    }

    @Override
    public List<Transaction> getByStatus(Status status){
        return transactions.values().stream().filter((t)->t.getStatus()==status).collect(Collectors.toList());
    }
    
}
