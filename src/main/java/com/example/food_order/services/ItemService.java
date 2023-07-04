package com.example.food_order.services;

import com.example.food_order.dto.ItemDto;
import com.example.food_order.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> searchItems(String searchTerm);
    public List<Item> fetchAll();
    ItemDto save(ItemDto itemDto);
}
