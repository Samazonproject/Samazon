package com.cy.example.demo.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private Set<Product> products = new HashSet<>();

    private BigDecimal totalPrice = new BigDecimal(0);

    @ManyToMany(mappedBy = "history")
    private Set<User> historyOwners;

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

    public Set<User> getHistoryOwners() {
        return historyOwners;
    }

    public void setHistoryOwners(Set<User> historyOwners) {
        this.historyOwners = historyOwners;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
