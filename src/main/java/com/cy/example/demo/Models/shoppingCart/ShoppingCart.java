package com.cy.example.demo.Models.shoppingCart;

import com.cy.example.demo.Models.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToMany
    private Set<Product> cartItems;

    private BigDecimal total;
}
