package com.example.food_order.services.impl;

import com.example.food_order.entity.AdminPage;
import com.example.food_order.entity.Order;
import com.example.food_order.entity.User;
import com.example.food_order.pojo.OrderPojo;
import com.example.food_order.repo.OrderRepo;
import com.example.food_order.services.AdminPageService;
import com.example.food_order.services.OrderService;
import com.example.food_order.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final UserService userService;
    private final AdminPageService adminPageService;

    @Override
    public void saveData(OrderPojo orderPojo) throws IOException {
        Order order = new Order();

        User user = userService.fetchById(orderPojo.getUser_id()).get();
        AdminPage adminPage = adminPageService.fetchById(orderPojo.getAdminPage_id()).get();
        order.setAdminPage(adminPage);
        order.setUser(user);

        orderRepo.save(order);

    }

    @Override
    public List<Object> getOrderList(Integer user_id) {
        return orderRepo.getOrderListByUser(user_id);
    }

    @Override
    public Optional<Order> fetchAll(Integer id) {
        return orderRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepo.deleteById(id);
    }


}
