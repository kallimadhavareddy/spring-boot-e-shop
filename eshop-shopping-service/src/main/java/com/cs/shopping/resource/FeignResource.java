package com.cs.shopping.resource;

import com.cs.shopping.client.CustomerClient;
import com.cs.shopping.data.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignResource {
    @Autowired
    CustomerClient customerClient;
    @GetMapping("/feign/test/")
    public Customer getCustomer(@RequestParam("emailId") final String emailId){
        log.info("Testing feign client ");
        return customerClient.getCustomer(emailId);
    }
}
