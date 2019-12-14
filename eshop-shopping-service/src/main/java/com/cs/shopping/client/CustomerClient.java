package com.cs.shopping.client;

import com.cs.shopping.data.Customer;
import com.cs.shopping.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@FeignClient(name = "eshop-customer-client")

@FeignClient(name="eshop-customer-client",url="http://localhost:8888/customer/api/service1")
@Service
public interface CustomerClient {
    @GetMapping("/customers/{customerId}")
    Customer findCustomerById(@PathVariable("customerId") int customerId);
    @GetMapping("/customer/")
    List<?> getCustomer(@RequestParam("emailId") final String emailId);
}
