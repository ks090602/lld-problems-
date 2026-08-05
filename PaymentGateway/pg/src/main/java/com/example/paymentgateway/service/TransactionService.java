package com.example.paymentgateway.service;

import java.util.List;

import com.example.paymentgateway.enums.PaymentMethod;
import com.example.paymentgateway.enums.Status;
import com.example.paymentgateway.model.Transaction;
import com.example.paymentgateway.repo.transactionrepo.TransactionRepo;

public class TransactionService {
    private final TransactionRepo transactionRepo;
    public TransactionService(TransactionRepo transactionRepo)
    {
        this.transactionRepo = transactionRepo;
    }

    public Transaction createNewTransaction(Integer attemptNumber,PaymentMethod paymentMethod)
    {
        Transaction transaction = new Transaction(attemptNumber, paymentMethod);
        return transaction;
    }

    public void saveTransaction(Transaction t)
    {
        transactionRepo.save(t);
    }

    public Transaction getTransactionById(Integer tId)
    {
        return transactionRepo.getById(tId);
    }

    public void removeTransaction(Integer tId)
    {
        transactionRepo.remove(tId);
    }

    public List<Transaction> getAllTransactions()
    {
        return transactionRepo.getAllTransactions();
    }

    public List<Transaction> getAllTransactionsByStatus(Status s)
    {
        return transactionRepo.getByStatus(s);
    }


}
