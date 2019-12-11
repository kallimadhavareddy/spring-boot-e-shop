package com.cs.shopping.persistance.entity;

import lombok.Getter;
import lombok.Setter;

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
@Setter
@Getter
public class Items {
    @Column(name="item_id")
    @Id
    @GeneratedValue
    private int itemId;
    @Column(name="product_id")
    private int productId;
    @Column(name="price")
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="basket_id",nullable = false)
    private Basket basket;
}
