package com.example.food_order;

import com.example.food_order.entity.AdminPage;
import com.example.food_order.repo.AdminPageRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminPageTesting {
    @Autowired
    private AdminPageRepo adminPageRepo;

    @Test

    @Order(1)

    @Rollback(value = false)

    public void saveProductTest() {

        AdminPage product = AdminPage.builder()

                .item_name("tomato")

                .item_price("Rs 100")

                .item_description("A good tomato")
                .item_rating(3)

                .build();


        adminPageRepo.save(product);


        Assertions.assertThat(product.getId()).isGreaterThan(0);

    }
}