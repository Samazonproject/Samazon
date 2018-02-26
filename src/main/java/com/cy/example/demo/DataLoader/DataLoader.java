package com.cy.example.demo.DataLoader;


import com.cy.example.demo.Models.Product;
import com.cy.example.demo.Models.Role;
import com.cy.example.demo.Models.User;
import com.cy.example.demo.Repositories.ProductRepository;
import com.cy.example.demo.Repositories.RoleRepository;
import com.cy.example.demo.Repositories.ShoppingCartRepository;
import com.cy.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");
//
//        roleRepository.save(new Role("USER"));
//        roleRepository.save(new Role("ADMIN"));

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

        Product product1 = new Product("Nike Shoe", "athletic shoes", new BigDecimal ("100.0"), "Nike", "blue", "max cushion","https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/iersgpa3x5c3kbaxq9rz/hyperdunk-2017-elena-delle-donne-limited-basketball-shoe-kl74xN.jpg");
productRepository.save(product1);

        Product product2 = new Product("Nike Shorts", "athletic shorts", new BigDecimal ("10"), "Nike", "red", "dryfit","https://goo.gl/pvAXA9");
        productRepository.save(product2);

        Product product3 = new Product("Nike Socks", "athletic socks", new BigDecimal("5"), "Nike", "white", "max cushion", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyeiC2hontKL7KCbGSwwC6LFgeb2jB6SIslL7XqZ8g0P9_W1HiEA");
        productRepository.save(product3);

       Product product4= new Product("Travis ", "athletic shoes", new BigDecimal("120"), "Nike", "blue", "max cushion", "https://bergdorfgoodman.scene7.com/is/image/bergdorfgoodman/BGN4TKP_01_m?&wid=400&height=500");
       productRepository.save(product4);

       Product product5 = new Product("Chanel Shoe", "athletic shoes", new BigDecimal("500"), "Nike", "blue", "max cushion", "https://images.unsplash.com/photo-1491553895911-0055eca6402d?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=4505ad993e9162d9ccf05d2670a26916&auto=format&fit=crop&w=500&q=60");
       productRepository.save(product5);

        Product product6 = new Product("Burberry Shoe", "athletic shoes", new BigDecimal("100"), "Nike", "blue", "max cushion", "https://images.unsplash.com/photo-1467646835273-19bc88c4dffb?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=cfcad70cf784ca0a4f8210d954926d26&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product6);
//
        Product product7 = new Product("Gucci", "athletic shoes", new BigDecimal("700"), "Nike", "blue", "max cushion", "https://images.unsplash.com/photo-1513188732907-5f732b831ca8?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=1e03fa93d70e39f2423fbd3d643d61e1&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product7);

        Product product8 = new Product("Jordan Shoe", "athletic shoes", new BigDecimal("100"), "Nike", "blue", "max cushion", "https://images.unsplash.com/photo-1494955464529-790512c65305?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=2a58b00dc3c3889ce91b3345c19169ea&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product8);

        Product product9 = new Product("Versace Shoe", "athletic shoes", new BigDecimal("100"), "Nike", "blue", "max cushion", "https://images.unsplash.com/photo-1474432420717-75023248d5b8?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=54258149efaba0be0b866de63037ea14&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product9);

        Product product10 = new Product("Rolex", "watch", new BigDecimal("100000"), "Gold", "Gold", "Classy", "https://images.unsplash.com/photo-1456444029056-7dfaeeb83a19?ixlib=rb-0.3.5&s=e8c8fe958bf4175b78c2d5df6979c240&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product10);

        Product product11 = new Product("Rolex 2", "watch", new BigDecimal("1000000000"), "Gold", "Gold", "Presdiential", "https://images.unsplash.com/photo-1515090916855-28e4d1a230ec?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=76a2e18242bd4e65eb489af5785c05ca&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product11);

        Product product12 = new Product("Diamomd bracelet", "KAY jEWELERS", new BigDecimal("1000"), "KAY", "blue", "EXPENSIVE", "https://images.unsplash.com/photo-1506049420574-b51320eee265?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=1902f6b70764ed83252c7d00de2bcad7&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product12);

        Product product13 = new Product("tELSA MODEL X", "CAR", new BigDecimal("5000"), "Telsa", "blue", "Fast", "https://images.unsplash.com/photo-1453491945771-a1e904948959?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6293f851bba5d5016c47c9695b3adc52&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product13);

        Product product14 = new Product("Lambo", "Car", new BigDecimal("3000000"), "lambo", "green", "super fast", "https://images.unsplash.com/photo-1519440862171-af26cf8c2a85?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=5dd79d27eb5f115f4d2f6833327bd3d2&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product14);

        Product product15 = new Product("Italian Cotton Suit", "cotton ",new BigDecimal( "100"), "Express", "blue", "athletic fit", "https://images.unsplash.com/photo-1506072590044-75de1b7b7806?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=7a37c5d844e3e51d2c2299ddbf710203&auto=format&fit=crop&w=500&q=60");
        productRepository.save(product15);

//        Had to comment out test relationship throwing null values to productlist2 page within thymleaf

        /*user1.addProduct2ShoppingCart(product1);
        user1.addProduct2ShoppingCart(product2);
        user2.addProduct2ShoppingCart(product2);
        user1.removeProductFromShoppingCart(product2);
        shoppingCartRepository.save(user1.getShoppingCarts());
        shoppingCartRepository.save(user2.getShoppingCarts());*/
    }
}