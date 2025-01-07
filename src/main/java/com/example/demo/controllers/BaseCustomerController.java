package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.CustomerRepository;
import com.example.demo.models.Customer;

@RestController
@RequestMapping("/customers")
public class BaseCustomerController {

  private final CustomerRepository repository;

  public BaseCustomerController(CustomerRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Customer> getCustomer() {
    return repository.findAll();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomerById(@PathVariable String id) {

    if (repository.existsByCustomId(id) ) {
      repository.deleteCustomerByCustomId(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
}
