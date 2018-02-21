package com.cy.example.demo.Models.shoppingCart;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToMany
    private Set<ProductNumber> cartItems;

    private BigDecimal total;

    public ShoppingCart() {
        cartItems = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<ProductNumber> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<ProductNumber> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
