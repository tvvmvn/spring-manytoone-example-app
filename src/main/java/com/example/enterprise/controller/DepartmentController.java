package com.example.enterprise.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.enterprise.dao.DepartmentRepository;
import com.example.enterprise.dao.EmployeeRepository;
import com.example.enterprise.exception.DepartmentNotFoundException;
import com.example.enterprise.model.Department;
import com.example.enterprise.model.Employee;

import org.springframework.ui.Model;

@Controller
public class DepartmentController {

  private DepartmentRepository departmentRepository;
  private EmployeeRepository employeeRepository;

  DepartmentController(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
    this.departmentRepository = departmentRepository;
    this.employeeRepository = employeeRepository;
  }

  // Get all departments
  @GetMapping("/departments")
  public String getAll(Model model) {
    
    List<Department> departments = departmentRepository.findAll();

    model.addAttribute("departments", departments);

    return "department_list";
  }

  // Get a department
  @GetMapping("/department/{id}")
  public String getOne(@PathVariable("id") Long id, Model model) {
    
    Department department = departmentRepository.findById(id)
        .orElseThrow(() -> new DepartmentNotFoundException());

    model.addAttribute("department", department);

    List<Employee> employees = employeeRepository.findByDepartmentId(id);

    model.addAttribute("employees", employees);

    return "department_detail";
  }
}
