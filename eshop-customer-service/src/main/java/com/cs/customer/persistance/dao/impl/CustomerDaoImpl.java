package com.cs.customer.persistance.dao.impl;

import com.cs.customer.exception.CustomerNotFound;
import com.cs.customer.persistance.dao.CustomerDao;
import com.cs.customer.persistance.entity.Customer;
import com.cs.customer.persistance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> allCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByEmailId(String emailId) {
        return customerRepository.findById(emailId).orElseThrow(()-> new CustomerNotFound(String.format("Customer with id %s not exists!", emailId)));
    }

    @Override
    public void deleteCustomerByEmailId(String emailId) {
         customerRepository.deleteById(emailId);
    }
}
