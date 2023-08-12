package com.example.food_order.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderListPojo {
    private Integer id;
    private String image;
    private String item_name;
    private String item_price;

}
