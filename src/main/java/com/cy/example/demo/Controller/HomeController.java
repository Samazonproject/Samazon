package com.cy.example.demo.Controller;

import com.cy.example.demo.Models.Product;
import com.cy.example.demo.Models.ShoppingCart;
import com.cy.example.demo.Models.User;
import com.cy.example.demo.Repositories.ProductRepository;
import com.cy.example.demo.Repositories.ShoppingCartRepository;
import com.cy.example.demo.Repositories.UserRepository;
import com.cy.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;

/**
 * Created by ${TravisGray} on 11/13/2017.
 */

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
   private UserService userService;



@Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String index(Model model){

        return "index2";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model, Authentication auth){
        /*if(auth.getName().equals("USER")){*/
            model.addAttribute("user",new User());
            model.addAttribute("shoppingcart",new ShoppingCart());

        return "registration";
    }

    @PostMapping("/register")
    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){

        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "registration";
        }else{
            userService.saveUser(user);
            model.addAttribute("message","User Account Successfully Created");
        }
        return "index2";
    }

    @RequestMapping("/addproduct")
    public String addProduct(Model model, Product product){
        model.addAttribute("product", new Product());
        productRepository.save(product);
        return "addproduct";
    }

    @RequestMapping("/listproduct")
    public String listProduct(Model model, Product product){
        model.addAttribute("products", productRepository.findAll());
       return "listproduct2";
    }

    @GetMapping("/shoppingcart/product/{id}")
    public String addproductstoshoppingcart(@PathVariable long id, Model model,Authentication auth){
        Product product = productRepository.findOne(id);
        User user = userRepository.findByUsername(auth.getName());
        user.addProduct2ShoppingCart(product);
        return "addproducttocart";
    }

/*
 @RequestMapping("/addproducttoshoppingcart/{id}")
 public String addproducttoshoppingcart(HttpServletRequest request,@ModelAttribute("shoppingcart")ShoppingCart shoppingCart, Model model){

 String shoppingcartid = request.getParameter("shoppingcart.id");
 String productid = request.getParameter("product.id");
     shoppingCartRepository.save(shoppingCart);
     shoppingCart.addProduct2ShoppingCart(productRepository.findOne(new Long(productid)));
     shoppingCartRepository.save(shoppingCart);
     model.addAttribute("cartslist", shoppingCartRepository.findAll());
     model.addAttribute("products", productRepository.findAll());




     return "addproducttoshoppingcart";
 }
 */

    @RequestMapping("/addproducttoshoppingcart/{id}")
    public String addproducttoshoppingcart(@PathVariable("id") long id, Model model, Authentication auth){
        Product product =  productRepository.findOne(id);
        User user = userRepository.findByUsername(auth.getName());
        user.addProduct2ShoppingCart(product);
        ShoppingCart sc = (ShoppingCart) user.getShoppingCarts().toArray()[0];
        model.addAttribute("cart", sc);
        model.addAttribute("products", sc.getProducts());
        shoppingCartRepository.save(user.getShoppingCarts());
        userRepository.save(user);
        return "addproducttocart";
    }

    @RequestMapping("/productsdetail/{id}")
    public String detailProduct(@PathVariable ("id") long id, Model model, Product product){
        model.addAttribute("products", productRepository.findOne(id));
        return "detailproduct";
    }

    @GetMapping("/productupdate/{id}")
    public String updateProduct(@PathVariable ("id") long id, Model model, Product product){
        model.addAttribute("product", productRepository.findOne(id));
        return "addproduct";
    }


    @RequestMapping("/productdelete/{id}")
    public String delPersonInfo(@PathVariable("id") long id){
        productRepository.delete(id);
        return "redirect:/listproduct2";
    }


    @GetMapping("/listCustomer")
    public String customerList(Model model){
        model.addAttribute("listcustomer",userRepository.findAll());

        return "customerList";
    }




    @GetMapping("/search")
    public String getSearch(){
        return "searchform";
    }

    @PostMapping("/search")
    public String showSearchResults(HttpServletRequest request, Model model){
        String searchProducts = request.getParameter("search");
        model.addAttribute("search",searchProducts);
//

//        Expecting multiple parameters or else will throw No parameter available Need to pass as many as are in constructor in Entity.
        model.addAttribute("productsearch",productRepository.findAllByProductNameContainingIgnoreCase(searchProducts));
//
        return "searchproductlist";
    }



    // shows the order confirmation page and move shopping carts to orders
    @GetMapping("/confirmation")
    public String confirmation(Authentication auth){
        User user = userRepository.findByUsername(auth.getName());
        user.buyShoppingCart();
        user.setShoppingCarts(new HashSet<>());
        return "confirmation";
    }

    // shows the list of order hisotry
    @GetMapping("/listhistory")
    public String listHistory(Authentication auth, Model model){
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("orders", user.getHistory());
        return "listOrders";
    }



}


