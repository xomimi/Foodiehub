package com.example.food_order.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminPage {
    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "item_name", nullable = false)
    private String item_name;

    @Column(name = "item_price", nullable = false)
    private String item_price;

    @Column(name = "item_rating", length = 5, nullable = false)
    private Integer item_rating;

    @Column(name = "item_description", nullable = false)
    private String item_description;

    private String image;

    @Transient
    private String imageBase64;

}
