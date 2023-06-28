package com.example.food_order.services;

import com.example.food_order.dto.UserDto;
import com.example.food_order.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto) throws IOException;

    List<User> fetchAll();

    User fetchById(Integer id);

    void deleteById(Integer id);

    void sendEmail();

}
