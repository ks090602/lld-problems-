package com.example.paymentgateway.repo;

public interface IRepo<T, ID> {
    void save(T entity);
    T getById(ID id);
    void remove(ID id);
}
