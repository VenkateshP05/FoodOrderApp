package com.foodordersystem.FoodManagement.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepo;
    private Customer customer;
    @Autowired
    public CustomerService(CustomerRepository customerRepo){
        this.customer = customer;
        this.customerRepo = customerRepo;
    }

    public boolean customerExist(int customerId){

        return customerRepo.existsById(customerId);
    }
    public List<Customer> getCustomerDetails() {

        return customerRepo.findAll();
}

    public Optional<Customer> getCustomerDetailsById(int customerId) {

        return customerRepo.findById(customerId);
    }

    public String addCustomer(Customer customer) {
        customerRepo.save(customer);
        return "success";
    }

    public String updateCustomerDetails(Customer customer) {
        customerRepo.save(customer);
        return "success";
    }

    public void updateCustomerOrders(int customerId) {
        customer = new Customer();
        customer = customerRepo.getById(customerId);
        customer.setTotalOrders(customer.getTotalOrders()+1);
        customerRepo.save(customer);
    }
}
