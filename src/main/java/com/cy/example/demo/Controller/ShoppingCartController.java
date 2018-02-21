package com.cy.example.demo.Controller;

import com.cy.example.demo.Models.Product;
import com.cy.example.demo.Models.shoppingCart.ProductNumber;
import com.cy.example.demo.Models.shoppingCart.ShoppingCart;
import com.cy.example.demo.Repositories.ProductNumberRepository;
import com.cy.example.demo.Repositories.ProductRepository;
import com.cy.example.demo.Repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ProductNumberRepository productNumberRepository;

    @Autowired
    ProductRepository productRepository;

    final private String scDir = "shoppingCart/";

    @RequestMapping("/")
    public String getShoppingCart(Model model){
        for(ShoppingCart sc : shoppingCartRepository.findAll()){
            BigDecimal total = new BigDecimal(0);
            for(ProductNumber pn: sc.getCartItems()){
                total = total.add(pn.getProduct().getPrice().multiply(new BigDecimal(pn.getProductNum())));
            }
            sc.setTotal(total);
        }

        model.addAttribute("shoppingCars", shoppingCartRepository.findAll());
        return scDir + "list";
    }
}
