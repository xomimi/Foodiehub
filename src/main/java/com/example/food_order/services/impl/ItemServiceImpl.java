package com.example.food_order.services.impl;

import com.example.food_order.entity.Item;
import com.example.food_order.repo.ItemRepository;
import com.example.food_order.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> searchItems(String searchTerm) {
        return itemRepository.findByNameContainingIgnoreCase(searchTerm);
    }

    @Override
    public List<Item> fetchAll() {
        return itemRepository.findAll();
    }
}
