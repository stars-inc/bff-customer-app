package com.example.demo.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String customId;
  private String name;
  private String email;

  public Customer(String name, String email) {
    this.customId = UUID.randomUUID().toString();
    this.name = name;
    this.email = email;
  }

  public Customer() {}

  public String getCustomerId() { return customId; }

  public String getCustomerName() { return name; }

  public void setCustomerName(String name) {
    this.name = name;
  }

  public String getCustomerEmail() { return email; }

  public void setCustomerEmail(String email) {
    this.email = email;
  }
}
