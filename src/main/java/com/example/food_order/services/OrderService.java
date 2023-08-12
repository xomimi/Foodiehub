package com.example.food_order.services;

import com.example.food_order.entity.Order;
import com.example.food_order.pojo.OrderPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    void saveData(OrderPojo orderPojo) throws IOException;

    List<Object> getOrderList(Integer user_id);

    Optional<Order> fetchAll(Integer id);


    void deleteById(Integer id);
}
