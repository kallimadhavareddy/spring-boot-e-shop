package com.cs.shopping.persistance.dao.impl;

import com.cs.shopping.exception.ShoppingBasketException;
import com.cs.shopping.persistance.dao.BasketDao;
import com.cs.shopping.persistance.entity.Basket;
import com.cs.shopping.persistance.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasketDaoImpl implements BasketDao {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketDaoImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public Basket createBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public List<Basket> allBasket() {
        return basketRepository.findAll();
    }

    @Override
    public Basket getBasketById(int basketId) {
        return basketRepository.findById(basketId).orElseThrow(()-> new ShoppingBasketException(String.format("Shoping Basket with id %s not exists!", basketId)));
    }

    @Override
    public void deleteBasketById(int basketId) {
        basketRepository.deleteById(basketId);
    }
}
