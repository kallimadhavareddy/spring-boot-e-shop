package com.cs.shopping.resource;


import com.cs.shopping.data.Basket;
import com.cs.shopping.process.BasketService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BasketResource {
    private final BasketService basketService;


    @Autowired
    public BasketResource(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/baskets")
    public List<Basket> getCustomers(){
        log.info("inside the getCustomers");
        return basketService.getAllBasket();
    }

    @PostMapping("/basket")
    public Basket createCustomer(@RequestBody Basket basket){
        return basketService.createBasket(basket);
    }

    @GetMapping("/basket")
    @HystrixCommand(groupKey = "fallback",commandKey="fallback", fallbackMethod = "hystrixFallBack")
    public Basket getCustomer(@RequestParam final int basketId){

        return basketService.getBasket(basketId);
    }

    public String hystrixFallBack(){
        return "Target Application is down";
    }

    @DeleteMapping("/basket")
    public void deleteCustomer(@RequestParam final int basketId){
        basketService.getBasket(basketId);
    }
}
