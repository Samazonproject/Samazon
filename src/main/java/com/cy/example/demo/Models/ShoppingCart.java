package com.cy.example.demo.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private Set<Product> products = new HashSet<>();

    private BigDecimal totalPrice = new BigDecimal(0);

    @ManyToMany(mappedBy = "shoppingCarts")
    private Set<User> shoppingCartOwners;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Set<User> getShoppingCartOwners() {
        return shoppingCartOwners;
    }

    public void setShoppingCartOwners(Set<User> shoppingCartOwners) {
        this.shoppingCartOwners = shoppingCartOwners;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addProduct2ShoppingCart(Product product){
        this.products.add(product);
        this.totalPrice = this.totalPrice.add(product.getPrice());
    }

    public void removeProductFromShoppingCart(Product product){
        if(products.contains(product)){
            products.remove(product);
            this.totalPrice = this.totalPrice.subtract(product.getPrice());
        }else{
            System.out.println("This product does not exist");
        }
    }
}
