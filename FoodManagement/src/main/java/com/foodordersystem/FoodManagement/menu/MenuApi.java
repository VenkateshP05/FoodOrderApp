package com.foodordersystem.FoodManagement.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuApi {
    public MenuService menuService;
    @Autowired
    public MenuApi(MenuService menuService){

        this.menuService = menuService;
    }
    @GetMapping
    public List<Menu> getItems(){
        return menuService.getItems();
    }
    @PostMapping("/employee")
    public String addItemToMenu(@RequestBody Menu item){
        return menuService.addItemToMenu(item);
    }
    @GetMapping("{category}")
    public List<Menu> getItemsByCategory(@PathVariable int category){
        return menuService.getItemsByCategory(category);
    }

}
