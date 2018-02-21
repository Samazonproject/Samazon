package com.cy.example.demo.Repositories;

import com.cy.example.demo.Models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
