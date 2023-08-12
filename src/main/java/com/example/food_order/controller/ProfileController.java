package com.example.food_order.controller;

import com.example.food_order.entity.User;
import com.example.food_order.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProfileController {

    private final UserService userService;
    @GetMapping("/profile")
    public String getProfile(Model model) {
        User user = userService.fetchById(getUser(getCurrentUser()).getId()).get();
        model.addAttribute("user", getUser(getCurrentUser()));
        model.addAttribute("edi", User.builder()
                .imageBase64(getImageBase64(user.getImage()))
                .build());
        return "profilepage/profile.html";
    }


    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentemail = authentication.getName();
        return currentemail;
    }

    public User getUser(String email){
        User u = userService.fatchByEmail(email);
        return u;
    }
    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/photo_file/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}
