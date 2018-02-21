package com.cy.example.demo.Repositories;

import com.cy.example.demo.Models.shoppingCart.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}
