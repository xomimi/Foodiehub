package com.example.food_order.controller;

import com.example.food_order.entity.User;
import com.example.food_order.pojo.UserPojo;
import com.example.food_order.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class EditProfileController {
    private final UserService userService;
    @GetMapping("/editprofile")
    public String getStartPage(Model model){
        User user = userService.fetchById(getUser(getCurrentUser()).getId()).get();
        model.addAttribute("change", new UserPojo(user));
        return "profilepage/editprofile.html";
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
}
