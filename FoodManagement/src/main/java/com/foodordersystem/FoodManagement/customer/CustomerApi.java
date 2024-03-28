package com.foodordersystem.FoodManagement.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerApi {
    private CustomerService customerService;
    @Autowired
    public CustomerApi(CustomerService customerService){

        this.customerService = customerService;
    }
    @GetMapping("/employee")
    public List<Customer> getCustomersDetails(){
        return customerService.getCustomerDetails();
    }

    @GetMapping("{customerId}")
    public Optional<Customer> getCustomerDetailsById(@PathVariable int customerId){
        return customerService.getCustomerDetailsById(customerId);
    }

    @PostMapping
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping
    public String updateCustomerDetails(@RequestBody Customer customer){
        return customerService.updateCustomerDetails(customer);
    }
}
