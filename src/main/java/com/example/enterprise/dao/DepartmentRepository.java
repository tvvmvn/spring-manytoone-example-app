package com.example.enterprise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enterprise.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

