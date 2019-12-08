package com.cs.shopping.persistance.dao;


import com.cs.shopping.persistance.entity.Basket;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BasketDao {
    Basket createBasket(Basket basket);
    List<Basket> allBasket();
    Basket getBasketById(int basketId);
    void deleteBasketById(int basketId);
}
