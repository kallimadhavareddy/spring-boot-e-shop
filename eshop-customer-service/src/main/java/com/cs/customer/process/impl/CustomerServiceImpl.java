package com.cs.customer.process.impl;

import com.cs.customer.persistance.dao.CustomerDao;


import com.cs.customer.presentation.data.Customer;
import com.cs.customer.process.CustomerService;
import com.cs.customer.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
    private final ObjectMapperUtils objectMapperUtils;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao,ObjectMapperUtils objectMapperUtils) {
        this.customerDao = customerDao;
        this.objectMapperUtils= objectMapperUtils;
    }

    @Override

    public Customer createCustomer(Customer customer) {
        com.cs.customer.persistance.entity.Customer customerEntity = objectMapperUtils.map(customer, com.cs.customer.persistance.entity.Customer.class);
        return objectMapperUtils.map(customerDao.createCustomer(customerEntity),Customer.class);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return objectMapperUtils.mapAll(customerDao.allCustomers(),Customer.class);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomer(String emailId) {
        return objectMapperUtils.map(customerDao.getCustomerByEmailId(emailId),Customer.class);
    }
}
