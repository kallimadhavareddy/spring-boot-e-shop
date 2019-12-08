package com.cs.shopping.process.impl;

import com.cs.shopping.persistance.dao.BasketDao;
import com.cs.shopping.persistance.entity.Basket;
import com.cs.shopping.process.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketDao basketDao;
    @Autowired
    public BasketServiceImpl(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    @Override
    public Basket createBasket(Basket basket) {
        return basketDao.createBasket(basket);
    }

    @Override
    public List<Basket> getAllBasket() {
        return basketDao.allBasket();
    }

    @Override
    public void deleteBasket(int basketId) {
        basketDao.deleteBasketById(basketId);
    }

    @Override
    public Basket getBasket(int basketId) {
        return basketDao.getBasketById(basketId);
    }
}
