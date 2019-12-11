package com.cs.shopping.process.impl;

import com.cs.shopping.client.CustomerClient;
import com.cs.shopping.client.ProductClient;
import com.cs.shopping.data.Basket;
import com.cs.shopping.data.Customer;
import com.cs.shopping.data.Product;
import com.cs.shopping.persistance.dao.BasketDao;

import com.cs.shopping.persistance.entity.Items;
import com.cs.shopping.process.BasketService;
import com.cs.shopping.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketDao basketDao;
    private final ProductClient productClient;
    private final CustomerClient customerClient;
    private final ObjectMapperUtils objectMapperUtils;

    @Autowired
    public BasketServiceImpl(BasketDao basketDao,CustomerClient customerClient, ProductClient productClient,ObjectMapperUtils objectMapperUtils) {
        this.basketDao = basketDao;
        this.customerClient = customerClient;
        this.productClient = productClient;
        this.objectMapperUtils = objectMapperUtils;
    }

    @Override
    public Basket createBasket(Basket basket) {
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

        com.cs.shopping.persistance.entity.Basket basketEntity = objectMapperUtils.map(basket, com.cs.shopping.persistance.entity.Basket.class);
        Set<Items> items = basketEntity.getItems();
        items.stream().forEach(item ->item.setBasket(basketEntity) );
        basketEntity.setItems(items);
        return objectMapperUtils.map(basketDao.createBasket(basketEntity),Basket.class);
    }

    @Override
    public List<Basket> getAllBasket() {
        return objectMapperUtils.mapAll(basketDao.allBasket(),Basket.class);
    }

    @Override
    public void deleteBasket(int basketId) {
        basketDao.deleteBasketById(basketId);
    }

    @Override
    public Basket getBasket(int basketId) {
        return objectMapperUtils.map(basketDao.getBasketById(basketId),Basket.class);
    }
}
