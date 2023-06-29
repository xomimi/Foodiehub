package com.example.food_order.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static BCryptPasswordEncoder getPasswordEncoder() {
        return PASSWORD_ENCODER;
    }
}
