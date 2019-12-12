package com.cs.shopping.client;

import com.cs.shopping.data.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "eshop-customer-client")
@Service
public interface CustomerClient {
    @GetMapping("/customers/{customerId}")
    Customer findCustomerById(@PathVariable("customerId") int customerId);
    @GetMapping("/customer/")
    Customer getCustomer(@RequestParam("emailId") final String emailId);
}
