package com.foodordersystem.FoodManagement.order;

import com.foodordersystem.FoodManagement.customer.CustomerService;
import com.foodordersystem.FoodManagement.menu.Menu;
import com.foodordersystem.FoodManagement.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Integer.parseInt;

@Service
public class OrderService {
    private OrderRepository orderRepo;
    private MenuService menuService;
    private CustomerService customerService;
    @Autowired
    public OrderService(OrderRepository orderRepo, MenuService menuService,
                        CustomerService customerService){
        this.customerService = customerService;
        this.menuService = menuService;
        this.orderRepo = orderRepo;
    }
    public List<Orders> getOrdersByCustomerID(int customerId){
        if(customerId < 0)
            return orderRepo.findAll();
        return orderRepo.findByCustomerId(customerId);
    }

    public Map generateBill(Map<String, Integer> orderDetails,
                                             int customerId) {

        if(!customerService.customerExist(customerId)){
            Map<String, String> error = new HashMap<>();
            error.put("ERROR","Customer doesn't exist...please signUp");
            return error;
        }

        Map<String, Integer> bill = new LinkedHashMap<>();
        int total = 0;

        bill.put("CustomerId", customerId);
        bill.put("orderId", (int)(orderRepo.count()+1));

        for(String itemId : orderDetails.keySet()){
            int id = Integer.parseInt(itemId);

            Optional<Menu> menuItem  = menuService.getById(id);
            String item = String.format("%s x%s",menuItem.get().getItemName(),
                    Integer.toString(orderDetails.get(itemId)));

            int itemCost = orderDetails.get(itemId) * menuItem.get().getCost();

            bill.put(item, itemCost);
            total += itemCost;
        }
        bill.put("Total ", total);

        customerService.updateCustomerOrders(customerId);

        Orders order = new Orders(customerId,total,bill.toString());
        orderRepo.save(order);

        return bill;
    }

}
