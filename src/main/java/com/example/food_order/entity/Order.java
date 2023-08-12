package com.example.food_order.entity;

import jakarta.persistence.*;
import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item")
public class Order {

    @Id
    @SequenceGenerator(name = "orders_seq_gen", sequenceName = "orders_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "orders_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "adminpage_id")
    private AdminPage adminPage;
//    private int adminPage;


}
