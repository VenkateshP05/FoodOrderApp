package com.foodordersystem.FoodManagement.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomerId(int customerId);
}
