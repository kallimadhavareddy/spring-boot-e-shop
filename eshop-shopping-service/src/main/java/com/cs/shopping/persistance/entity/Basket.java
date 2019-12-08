package com.cs.shopping.persistance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="basket")
public class Basket {
    @Id
    @Column(name = "basket_id")
    @GeneratedValue
    private int basketId;
    @Column(name = "customerId")
    private int customerId;
    @Column(name = "description")
    private String description;
    @Column(name = "totalPrice")
    private double totalPrice;
    @OneToMany(fetch= FetchType.EAGER,cascade= CascadeType.ALL, mappedBy = "basket")
    private Set<Items> items;

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
