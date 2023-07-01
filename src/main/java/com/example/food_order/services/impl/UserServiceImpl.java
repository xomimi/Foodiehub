package com.example.food_order.services.impl;

import com.example.food_order.config.PasswordEncoderUtil;
import com.example.food_order.dto.UserDto;
import com.example.food_order.entity.User;
import com.example.food_order.repo.UserRepo;
import com.example.food_order.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public UserDto save(UserDto userDto) throws IOException {
        User user= new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullname());
        user.setMobileNo(userDto.getMobile_no());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userDto.getPassword()));

        user= userRepo.save(user);
        return new UserDto(user);
    }

    @Override
    public List<User> fetchAll() {
        return null;
    }

    @Override
    public User fetchById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void sendEmail() {

    }
}
