package com.foodordersystem.FoodManagement.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private MenuRepository menuRepo;
    @Autowired
    public MenuService(MenuRepository menuRepo){
        this.menuRepo = menuRepo;
    }
    public List<Menu> getItems(){
         //Menu mi = menuRepo.findAll().get(0);
         //System.out.println("Menuitems >>> "+ mi.getItemName()+" >> "+mi.getItemId());
         return menuRepo.findAll();
    }
    public int getCostByItemId(int itemId){
        return menuRepo.findCostByItemId(itemId);
    }

    public String getItemNameByItemId(int itemId){
        return menuRepo.findItemNameByItemId(itemId);
    }

    public Optional<Menu> getById(int id) {
        return menuRepo.findById(id);
    }

    public String addItemToMenu(Menu item) {
        menuRepo.save(item);
        return "success";
    }

    public List<Menu> getItemsByCategory(int category) {
        if(category == 1 || category == 0){
            return menuRepo.findByCategory(category);
        }
        return menuRepo.findAll();
    }
}
