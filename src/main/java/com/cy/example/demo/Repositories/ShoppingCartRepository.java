package com.cy.example.demo.Repositories;

import com.cy.example.demo.Models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
