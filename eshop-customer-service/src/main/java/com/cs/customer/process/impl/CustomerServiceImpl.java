package com.cs.customer.process.impl;

import com.cs.customer.persistance.dao.CustomerDao;
import com.cs.customer.persistance.entity.Customer;
import com.cs.customer.process.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.allCustomers();
    }

    @Override
    public void deleteCustomer(String emailId) {
        customerDao.deleteCustomerByEmailId(emailId);
    }

    @Override
    public Customer getCustomer(String emailId) {
        return customerDao.getCustomerByEmailId(emailId);
    }
}
