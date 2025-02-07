package com.example.enterprise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Department {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @NotNull
  private int code;

  @NotEmpty(message = "Name is required")
  private String name;

  // initializer
  public Department() {}

  public Department(int code, String name) {
    this.code = code;
    this.name = name;
  }

  // getter and setter
  public long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
