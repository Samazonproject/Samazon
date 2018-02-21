package com.cy.example.demo.DataLoader;


import com.cy.example.demo.Models.Product;
import com.cy.example.demo.Models.Role;
import com.cy.example.demo.Models.User;
import com.cy.example.demo.Repositories.ProductRepository;
import com.cy.example.demo.Repositories.RoleRepository;
import com.cy.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        // Add user roles
        User user1 = new User("bob@burger.com", "password", "Bobby", "Burger", true, "bob");
        user1.setRoles(Arrays.asList(userRole));
        userRepository.save(user1);



        User user2 = new User("jane@virgin.com", "password", "Jane", "Virgin", true, "jane");
        user2.setRoles(Arrays.asList(userRole));
        userRepository.save(user2);

        // Add admin roles
        User user3 = new User("admin@secure.com", "password", "Admin", "User", true, "admin");
        user3.setRoles(Arrays.asList(adminRole));
        userRepository.save(user3);

        User user4 = new User("clark@kent.com", "password", "Clark", "Kent", true, "clark");
        user4.setRoles(Arrays.asList(userRole, adminRole));
        userRepository.save(user4);


//         public Product(String productName, String productDesc, String price, String brand, String color, String feature) {
//            this.productName = productName;
//            this.productDesc = productDesc;
//            this.price = price;
//            this.brand = brand;
//            this.color = color;
//            this.feature = feature;
//        }

        Product product1 = new Product("Nike Shoe", "athletic shoes", new BigDecimal ("100.0"), "Nike", "blue", "max cushion");
        productRepository.save(product1);

        Product product2 = new Product("Nike Shoe", "athletic shorts", new BigDecimal ("10"), "Nike", "red", "dryfit");
        productRepository.save(product2);

        Product product3 = new Product("Nike Socks", "athletic socks", new BigDecimal("5"), "Nike", "white", "max cushion");
        productRepository.save(product3);

        Product product4= new Product("Travis ", "athletic shoes", new BigDecimal("120"), "Nike", "blue", "max cushion");
        productRepository.save(product4);

        Product product5 = new Product("Chanel Shoe", "athletic shoes", new BigDecimal("500"), "Nike", "blue", "max cushion");
        productRepository.save(product5);

        Product product6 = new Product("Burberry Shoe", "athletic shoes", new BigDecimal("100"), "Nike", "blue", "max cushion");
        productRepository.save(product6);

        Product product7 = new Product("Gucci", "athletic shoes", new BigDecimal("700"), "Nike", "blue", "max cushion");
        productRepository.save(product7);

        Product product8 = new Product("Jordan Shoe", "athletic shoes", new BigDecimal("100"), "Nike", "blue", "max cushion");
        productRepository.save(product8);

        Product product9 = new Product("Versace Shoe", "athletic shoes", new BigDecimal("100"), "Nike", "blue", "max cushion");
        productRepository.save(product9);

        Product product10 = new Product("Rolex", "watch", new BigDecimal("100000"), "Gold", "Gold", "Classy");
        productRepository.save(product10);

        Product product11 = new Product("Rolex 2", "watch", new BigDecimal("1000000000"), "Gold", "Gold", "Presdiential");
        productRepository.save(product11);

        Product product12 = new Product("Diamomd bracelet", "KY jEWELERS", new BigDecimal("1000"), "KAY", "blue", "EXPENSIVE");
        productRepository.save(product12);

        Product product13 = new Product("tELSA MODEL X", "CAR", new BigDecimal("5000"), "Telsa", "blue", "Fast");
        productRepository.save(product13);

        Product product14 = new Product("Lambo", "Car", new BigDecimal("3000000"), "lambo", "green", "super fast");
        productRepository.save(product14);

        Product product15 = new Product("Nike Shoe", "athletic shoes",new BigDecimal( "100"), "Nike", "blue", "max cushion");
        productRepository.save(product15);
    }
}