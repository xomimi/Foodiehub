package com.example.food_order.controller;

import com.example.food_order.dto.UserDto;
import com.example.food_order.entity.Item;
import com.example.food_order.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomePageController {
    ItemService itemService;
    @GetMapping("/home")
    public String getpage(Model model) {
        List<Item> items =  itemService.fetchAll();
        model.addAttribute("item", items);
        return "/homepage/home";
    }
}
