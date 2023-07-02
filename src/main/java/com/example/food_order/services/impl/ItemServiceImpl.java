package com.example.food_order.services.impl;

import com.example.food_order.dto.ItemDto;
import com.example.food_order.entity.Item;
import com.example.food_order.repo.ItemRepository;
import com.example.food_order.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public ItemDto save(ItemDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setRating(itemDto.getRating());
        item.setImage(itemDto.getImage());
        item = itemRepository.save(item);
        return new ItemDto(item);
    }
}
