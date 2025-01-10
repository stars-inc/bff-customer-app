package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
  @Transactional
  void deleteCustomerByCustomId(String id);
  boolean existsByCustomId(String id);
}
