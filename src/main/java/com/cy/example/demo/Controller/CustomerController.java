package com.cy.example.demo.Controller;

import com.cy.example.demo.Models.Customer;
import com.cy.example.demo.Models.Product;
import com.cy.example.demo.Models.User;
import com.cy.example.demo.Repositories.CustomerRepository;
import com.cy.example.demo.Repositories.ProductRepository;
import com.cy.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by ${TravisGray} on 11/13/2017.
 */

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
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
    public String showRegistrationPage(Model model){
        model.addAttribute("user",new User());
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
        return "index";
    }


//    @RequestMapping("/addproduct")
//    public String addProduct(Model model, Product product){
//        model.addAttribute("product", new Product());
//        productRepository.save(product);
//        return "addproduct";
//    }
//
//    @RequestMapping("/listproduct")
//    public String listProduct(Model model, Product product){
//        model.addAttribute("products", productRepository.findAll());
//       return "listproduct";
//    }

    //Added full Mapping for CustomerForm to display to Customer List

    @GetMapping("/addCustomer")
    public String customerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @PostMapping("/processCustomer")
    public String customerForm(@Valid @ModelAttribute("customer") Customer customer, Model model,BindingResult result)
    {
        if (result.hasErrors()){
            return "customerForm";
        }

        model.addAttribute("customers",customerRepository.findAll());
        customerRepository.save(customer);
        return "customerList";
    }

    @GetMapping("/listCustomer")
    public String customerList(Model model){
        model.addAttribute("customers",customerRepository.findAll());

        return "customerList";
    }
}
