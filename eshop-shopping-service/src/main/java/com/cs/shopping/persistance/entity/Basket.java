package com.cs.shopping.persistance.entity;

import lombok.Getter;
import lombok.Setter;

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
@Setter
@Getter
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

}
