package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.interfaces.CustomerRepository;
import com.example.demo.models.Customer;

import jakarta.annotation.PostConstruct;

@Service
public class InitCustomer {
  private CustomerRepository repository;

  private InitCustomer(CustomerRepository repository) {
    this.repository = repository;
  }

  @PostConstruct
  private void initCustomer() {
    repository.saveAll(
      List.of(
        new Customer("alex", "alexandr.bessm@gmail.com")
      )
    );
  }
}
