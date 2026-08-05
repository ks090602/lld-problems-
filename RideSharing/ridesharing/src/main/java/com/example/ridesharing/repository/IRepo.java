package com.example.ridesharing.repository;

import java.util.Optional;

public interface IRepo<Id,T> {
    Optional<T> getById(Id id);
    void save(T t);
    void remove(Id id);
}
