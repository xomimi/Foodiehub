package com.example.food_order.controller;


import com.example.food_order.dto.ItemDto;
import com.example.food_order.entity.Item;
import com.example.food_order.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;
    private int itm = 9;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/search")
    public List<Item> searchItems(@RequestParam("q") String searchTerm) {
        return itemService.searchItems(searchTerm);
    }

    public List<Item> getItem(){
        List<Item> items= getAll();
        List<Item> items1 = new ArrayList<>();
        for(int i = 0; i < itm; i++){
            items1.add(items.get(i));
        }
//        if(items.size())
        itm += 9;
        return items1;
    }
    public List<Item> getAll(){
        return itemService.fetchAll();
    }

    @PostMapping("/saveItem")
        public void addItem(@Valid ItemDto itemDto){
            itemService.save(itemDto);
        }
}

