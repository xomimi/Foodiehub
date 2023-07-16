package com.example.food_order.repo;

import com.example.food_order.entity.Booking;
import org.springframework.stereotype.Repository;

@Repository


public interface BookingRepository extends jpaRepository<Booking, Long> {
    void save(Booking booking);
}
