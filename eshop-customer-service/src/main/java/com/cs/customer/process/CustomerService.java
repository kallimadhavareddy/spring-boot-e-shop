package com.cs.customer.process;


import com.cs.customer.presentation.data.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomer();
    void deleteCustomer(int id);
    Customer getCustomer(String emailId);
}
