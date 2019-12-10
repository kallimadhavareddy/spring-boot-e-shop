package com.cs.shopping.resource;


import com.cs.shopping.client.CustomerClient;
import com.cs.shopping.client.ProductClient;
import com.cs.shopping.data.Customer;
import com.cs.shopping.data.Product;
import com.cs.shopping.persistance.entity.Basket;
import com.cs.shopping.process.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasketResource {
    private final BasketService basketService;
    private final ProductClient productClient;
    private final CustomerClient customerClient;

    @Autowired
    public BasketResource(BasketService basketService,CustomerClient customerClient, ProductClient productClient) {
        this.basketService = basketService;
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    @GetMapping("/baskets")
    public List<Basket> getCustomers(){
        return basketService.getAllBasket();
    }

    @PostMapping("/basket")
    public Basket createCustomer(Basket basket){
        if(basket.getBasketId()>0){
            Product product = productClient.findProductById(basket.getBasketId());
            if(product!=null){
                System.out.println("Product is not null");
            }
        }
        if(basket.getItems()!=null){
            basket.getItems().stream().peek(items -> {
                if(items.getProductId()>0){
                    Customer customer = customerClient.findCustomerById(items.getProductId());
                    if(customer!=null){
                        System.out.println("Customer is not null");
                    }
                }
            });
        }
        return basketService.createBasket(basket);
    }

    @GetMapping("/basket")
    public Basket getCustomer(@RequestParam final int basketId){
        return basketService.getBasket(basketId);
    }

    @DeleteMapping("/basket")
    public void deleteCustomer(@RequestParam final int basketId){
        basketService.getBasket(basketId);
    }
}
