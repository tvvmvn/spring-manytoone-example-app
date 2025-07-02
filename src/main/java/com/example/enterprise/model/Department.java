package com.example.enterprise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Department {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  @Column(nullable = false)
  private int code;

  @Column(nullable = false)
  private String name;

  // @OneToMany
  // @JoinColumn
  // private List<Employee> employees[];

  //
  public Department() {}

  public Department(int code, String name) {
    this.code = code;
    this.name = name;
  }

  // getter and setter
  public int getId() {
    return id;
  }

  public void setId(int id) {
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
