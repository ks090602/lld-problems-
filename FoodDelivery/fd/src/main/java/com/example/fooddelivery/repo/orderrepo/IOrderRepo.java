package com.example.fooddelivery.repo.orderrepo;

import com.example.fooddelivery.model.Order;

public interface IOrderRepo {
    Order save(Order o);
    Order get(int oId);
}
