package com.cy.example.demo;

import com.cy.example.demo.Models.Product;
import com.cy.example.demo.Models.Role;
import com.cy.example.demo.Models.ShoppingCart;
import com.cy.example.demo.Models.User;
import com.cy.example.demo.Repositories.ProductRepository;
import com.cy.example.demo.Repositories.RoleRepository;
import com.cy.example.demo.Repositories.ShoppingCartRepository;
import com.cy.example.demo.Repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    public void runRepository(){
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        // Add user roles
        User user1 = new User("harry@burger.com", "password", "Bobby", "Burger", true, "bob");
        user1.setRoles(Arrays.asList(userRole));
        user1.setShoppingCarts(new HashSet<>());
        userRepository.save(user1);



        User user2 = new User("rob@virgin.com", "password", "Jane", "Virgin", true, "jane");
        user2.setRoles(Arrays.asList(userRole));
        user2.setShoppingCarts(new HashSet<>());
        userRepository.save(user2);

        Product product1 = new Product("Adidas Shoe", "athletic shoes", new BigDecimal("100.0"), "Nike", "blue", "max cushion");
        productRepository.save(product1);

        Product product2 = new Product("Shake Shoe", "athletic shorts", new BigDecimal ("10"), "Nike", "red", "dryfit");
        productRepository.save(product2);

        user1.addProduct2ShoppingCart(product1);
        user1.addProduct2ShoppingCart(product2);
        user2.addProduct2ShoppingCart(product2);
        user1.removeProductFromShoppingCart(product2);

    }
}
