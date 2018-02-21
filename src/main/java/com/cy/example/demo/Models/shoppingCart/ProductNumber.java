package com.cy.example.demo.Models.shoppingCart;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "cartItems")
    private List<ShoppingCart> shoppingCartList;

    public ProductNumber() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }
}
