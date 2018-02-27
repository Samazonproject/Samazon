package com.cy.example.demo.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_DATA")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ShoppingCart> shoppingCarts;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ShoppingCart> history;


    //use Fetch Type Eager user all data will be avivalible for this object
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String email, String password, String firstName, String lastName, boolean enabled, String username) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.username = username;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Set<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public Set<ShoppingCart> getHistory() {
        return history;
    }

    public void setHistory(Set<ShoppingCart> history) {
        this.history = history;
    }

    public void buyShoppingCart(){
        ShoppingCart sc = (ShoppingCart) this.shoppingCarts.toArray()[0];
        if(history == null){
            history = new HashSet<>();
        }
        this.history.add(sc);
    }

    public void addProduct2ShoppingCart(Product product) {
        ShoppingCart sc = new ShoppingCart();
        if(shoppingCarts.size() == 0){
            shoppingCarts.add(sc);
        }else{
            for(ShoppingCart shoppingCart : shoppingCarts){
                sc = shoppingCart;
            }
        }
        sc.addProduct2ShoppingCart(product);
    }

    public void removeProductFromShoppingCart(Product product) {
        ShoppingCart sc = new ShoppingCart();
        if(shoppingCarts.size() == 0){
            System.out.println("Shopping cart does not even exist which means product cannot be removed");
            return;
        }else{
            for(ShoppingCart shoppingCart : shoppingCarts){
                sc = shoppingCart;
            }
        }
        sc.removeProductFromShoppingCart(product);
    }
}
