package com.cs.customer.process;

import com.cs.customer.persistance.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomer();
    void deleteCustomer(String emailId);
    Customer getCustomer(String emailId);
}
