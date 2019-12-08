package com.cs.shopping.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "basket_items")
public class Items {
    @Column(name="item_id")
    @Id
    @GeneratedValue
    private int itemId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="basket_id",nullable = false)
    private Basket basket;
    @Column(name="product_id")
    private int productId;
    @Column(name="price")
    private double price;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
