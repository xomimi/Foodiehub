package com.example.food_order.controller;


import com.example.food_order.entity.Item;
import com.example.food_order.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/search")
    public List<Item> searchItems(@RequestParam("q") String searchTerm) {
        return itemService.searchItems(searchTerm);
    }
}

