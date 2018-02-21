package com.cy.example.demo.Repositories;

import com.cy.example.demo.Models.Product;
import com.cy.example.demo.Models.shoppingCart.ProductNumber;
import org.springframework.data.repository.CrudRepository;

public interface ProductNumberRepository extends CrudRepository<ProductNumber, Long>{
    ProductNumber findByProduct(Product p);
}
