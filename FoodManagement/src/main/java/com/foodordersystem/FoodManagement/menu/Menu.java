package com.foodordersystem.FoodManagement.menu;

import jakarta.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    @Column(unique = true, nullable = false)
    private String itemName;
    private int cost;
    private int category;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }






//    private Map<String, Integer> breakfastItems ;
//    private Map<String, Integer> dinnerItems;
//    private Map<String, Integer> menu;
//    public  Map<String, Integer> getBreakfastItems(){
//        breakfastItems = new HashMap<>();
//        breakfastItems.put("Idli",30);
//        breakfastItems.put("Dosa",20);
//        breakfastItems.put("Pongal",30);
//        breakfastItems.put("Poori",20);
//        breakfastItems.put("Vada",10);
//        return breakfastItems;
//    }
//    public Map<String, Integer> getDinnerItems(){
//        dinnerItems = new HashMap<>();
//        dinnerItems.put("Biryani", 200);
//        dinnerItems.put("Veg Meals",50);
//        dinnerItems.put("NonVeg Meals",100);
//        dinnerItems.put("chapati",10);
//        dinnerItems.put("Fried Rice",70);
//        return dinnerItems;
//    }
//
//    public Map<String, Integer> getMenuItems(){
//        menu = new HashMap<>();
//        menu.putAll(this.getBreakfastItems());
//        menu.putAll(this.getDinnerItems());
//        return menu;
//    }
//
//    public Map<String, Integer> getItems(String category){
//        if(category.equals(null)){
//            return this.getMenuItems();
//        }
//        else if(category.equals("breakfast"))
//            return this.getBreakfastItems();
//        else
//            return this.getDinnerItems();
//    }
}