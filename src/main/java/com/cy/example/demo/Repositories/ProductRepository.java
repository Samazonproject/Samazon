package com.cy.example.demo.Repositories;

import com.cy.example.demo.Models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {


    Iterable<Product> findAllByProductNameContainingIgnoreCase(String searchProducts);
}
