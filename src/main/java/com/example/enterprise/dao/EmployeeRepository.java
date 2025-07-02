package com.example.enterprise.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enterprise.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  List<Employee> findByDepartmentId(Integer id);
}

