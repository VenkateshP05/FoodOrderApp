package com.foodordersystem.FoodManagement.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/{customerId}/order")
public class OrderApi {
    private OrderService orderService;
    @Autowired
    public OrderApi(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping
    public List<Orders> getOrdersByCustomerID(@PathVariable("customerId") int customerId){

        return orderService.getOrdersByCustomerID(customerId);
    }
    @PostMapping
    public Map generateBill (@RequestBody Map<String, Integer> orderDetails,
                                                @PathVariable("customerId") int customerId){
        if(customerId < 0){
            Map<String, String> error = new HashMap<>();
            error.put("ERROR","You Can't place order as an Employee" +
                    "...Please go with customer account");
            return error;
        }
        return orderService.generateBill(orderDetails, customerId);
    }

}
