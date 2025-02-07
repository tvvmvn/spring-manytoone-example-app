package com.example.enterprise.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.enterprise.dao.EmployeeRepository;
import com.example.enterprise.model.Employee;

import org.springframework.ui.Model;

@Controller
public class EmployeeController {

  private EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  // Get all employees
  @GetMapping("/")
  public String getAll(Model model) {
    List<Employee> employees = repository.findAll();

    model.addAttribute("employees", employees);

    return "employee_list";
  }
}
