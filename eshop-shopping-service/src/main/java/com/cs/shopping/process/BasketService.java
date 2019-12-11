package com.cs.shopping.process;



import com.cs.shopping.data.Basket;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BasketService {
    Basket createBasket(Basket basket);
    List<Basket> getAllBasket();
    void deleteBasket(int basketId);
    Basket getBasket(int basketId);
}
