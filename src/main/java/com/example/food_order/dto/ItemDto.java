package com.example.food_order.dto;

import com.example.food_order.entity.Item;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;

    @NotEmpty(message = "Email can't be empty")
    private String name;

    @NotEmpty(message = "Email can't be empty")
    private double price;

    @NotEmpty(message = "Email can't be empty")
    private int rating;

    @NotEmpty(message = "Image can't be empty")
    private String image;

    public ItemDto(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.rating = item.getRating();
        this.image = item.getImage();
    }
}

