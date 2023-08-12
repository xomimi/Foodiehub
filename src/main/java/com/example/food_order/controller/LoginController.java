package com.example.food_order.controller;

import com.example.food_order.pojo.UserPojo;
import com.example.food_order.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public String getpage(Model model) {
        model.addAttribute("user", new UserPojo());
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        System.out.println("Request hit at register");
        model.addAttribute("user", new UserPojo());
        return "register";
    }

    @PostMapping("/logout")
    public  String logoutMethod(Authentication authentication){
        if(authentication.isAuthenticated()){
            SecurityContextHolder.clearContext();
        }
        return "redirect:/login";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserPojo userPojo) throws IOException {
        System.out.println(userPojo);
        userService.save(userPojo);
        return "/login";
    }
}
