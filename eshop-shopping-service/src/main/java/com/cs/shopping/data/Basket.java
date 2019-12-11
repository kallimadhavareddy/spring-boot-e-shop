package com.cs.shopping.data;

import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
public class Basket {
    private int basketId;
    private int customerId;
    private String description;
    private double totalPrice;
    private Set<Items> items;
}
