package com.example.food_order.repo;

import com.example.food_order.entity.AdminPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminPageRepo extends JpaRepository<AdminPage,Integer> {
}
