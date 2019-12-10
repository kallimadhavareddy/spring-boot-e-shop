package com.cs.customer.persistance.repository;

import com.cs.customer.persistance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmailId(String emailId);
}
