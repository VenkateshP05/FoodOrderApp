package com.foodordersystem.FoodManagement.order;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int customerId;
    private int orderCost;
    @Column
    private String orderDetails;

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Orders() {
    }

    public Orders(int customerId, int orderCost, String orderDetails) {
        this.orderDetails = orderDetails;
        this.customerId = customerId;
        this.orderCost = orderCost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(int orderCost) {
        this.orderCost = orderCost;
    }
}
