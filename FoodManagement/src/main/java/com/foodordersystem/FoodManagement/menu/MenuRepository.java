package com.foodordersystem.FoodManagement.menu;

import com.foodordersystem.FoodManagement.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    int findCostByItemId(int itemId);
    String findItemNameByItemId(int itemId);

    List<Menu> findByCategory(int category);
}
