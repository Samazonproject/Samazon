package com.cy.example.demo.Models.shoppingCart;

import com.cy.example.demo.Models.Product;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Product product;

    private long productNum;



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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getProductNum() {
        return productNum;
    }

    public void setProductNum(long productNum) {
        this.productNum = productNum;
    }
}
