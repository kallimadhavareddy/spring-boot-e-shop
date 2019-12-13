package com.cs.shopping.resource;

import com.cs.shopping.client.CustomerClient;
import com.cs.shopping.data.Customer;
import com.cs.shopping.util.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FeignResource {
    @Autowired
    CustomerClient customerClient;
    @Autowired
    ObjectMapperUtils objectMapperUtils;
    @GetMapping("/feign/test/")
    public List<Customer> getCustomer(@RequestParam("emailId") final String emailId){
        log.info("Testing feign client ");
        List customers = customerClient.getCustomer(emailId);
        log.info("customers{}",customers.size());
        return  objectMapperUtils.mapAll(customers,Customer.class);
    }
}
