package com.example.enterprise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  
  @NotEmpty
  private String name;

  @Email
  private String email;

  @NotNull
  @ManyToOne
  private Department department;

  // initializer
  public Employee() {};

  public Employee(String name, String email, Department department) {
    this.name = name;
    this.email = email;
    this.department = department;
  }

  // getter and setter
  public long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Department getDepartment() {
    return this.department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}