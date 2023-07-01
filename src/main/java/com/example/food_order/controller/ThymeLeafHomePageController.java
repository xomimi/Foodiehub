package com.example.food_order.controller;

import com.example.food_order.dto.HomePageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("th-home")
@RequiredArgsConstructor
public class ThymeLeafHomePageController {
    @GetMapping("create")
    public String getFormPage(Model model){
        model.addAttribute("home", new HomePageDto());
        return "homepage/home.html";
    }
}