package com.cs.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "eshop-customer-client")
@Service
public interface CustomerClient {
    @GetMapping("/customer/{customerId}")
    List findCustomerById(@PathVariable("customerId") int customerId);
}
