package com.example.food_order.repo;

import com.example.food_order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {


    @Query(value = "select oi.id,oi.adminpage_id,oi.user_id,ap.image,\n" +
            "       ap.item_name,\n" +
            "       ap.item_price\n" +
            "from order_item oi\n" +
            "         inner join admin_page ap on ap.id = oi.adminpage_id\n" +
            "         inner join users u on u.id = oi.user_id where oi.user_id=:user_id",nativeQuery = true)
    List<Object> getOrderListByUser(@Param("user_id") Integer user_id);
}
