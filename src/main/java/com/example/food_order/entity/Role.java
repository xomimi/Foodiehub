package com.example.food_order.entity;

import jakarta.persistence.*;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wpms_role")
public class Role {
    @Id
    @SequenceGenerator(name = "kryss_role_seq_gen",allocationSize = 1,sequenceName = "kryss_role_seq_gen")
    @GeneratedValue(generator = "kryss_role_seq_gen",strategy = GenerationType.SEQUENCE)
    private  Integer id;

    @Column(name = "role", nullable = false)
    private  String name;
}
