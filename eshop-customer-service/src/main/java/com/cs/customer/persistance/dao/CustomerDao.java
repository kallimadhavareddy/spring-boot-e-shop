package com.cs.customer.persistance.dao;

import com.cs.customer.persistance.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerDao {
    Customer createCustomer(Customer customer);
    List<Customer> allCustomers();
    Customer getCustomerByEmailId(String emailId);
    void deleteCustomerById(int id);
}
