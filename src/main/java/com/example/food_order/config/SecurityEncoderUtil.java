package com.example.food_order.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityEncoderUtil {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
}
