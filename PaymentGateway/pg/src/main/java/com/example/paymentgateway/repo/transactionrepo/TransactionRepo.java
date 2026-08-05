package com.example.paymentgateway.repo.transactionrepo;

import java.util.List;

import com.example.paymentgateway.enums.Status;
import com.example.paymentgateway.model.Transaction;
import com.example.paymentgateway.repo.IRepo;

public interface TransactionRepo extends IRepo<Transaction, Integer>{
    List<Transaction> getAllTransactions();
    List<Transaction> getByStatus(Status status);
}