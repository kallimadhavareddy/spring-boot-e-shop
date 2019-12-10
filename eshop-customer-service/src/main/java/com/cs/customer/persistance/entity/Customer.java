package com.cs.customer.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESHOP_CUSTOMER")
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
}
