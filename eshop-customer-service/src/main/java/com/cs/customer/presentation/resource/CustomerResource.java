package com.cs.customer.presentation.resource;

import com.cs.customer.persistance.entity.Customer;
import com.cs.customer.process.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerResource {
    private final CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomer();
    }

    @PostMapping("/customer")
    public Customer createCustomer(Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam final String emailId){
        return customerService.getCustomer(emailId);
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(@RequestParam final String emailId){
        customerService.deleteCustomer(emailId);
    }
}
