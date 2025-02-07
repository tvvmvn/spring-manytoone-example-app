package com.example.enterprise.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.enterprise.dao.DepartmentRepository;
import com.example.enterprise.dao.EmployeeRepository;
import com.example.enterprise.model.Department;
import com.example.enterprise.model.Employee;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
    
    return args -> {

      // Seed data only at first 
      if (departmentRepository.count() == 0) {

        // Departments
        Department d1 = new Department(100, "Human Resource");
        Department d2 = new Department(200, "Business");
        Department d3 = new Department(300, "Accounts");

        log.info("Preloading " + departmentRepository.save(d1));
        log.info("Preloading " + departmentRepository.save(d2));
        log.info("Preloading " + departmentRepository.save(d3));

        // Employees
        Employee e1 = new Employee("John Doe", "johndoe@example.com", d1);
        Employee e2 = new Employee("Jane Doe", "janedoe@example.com", d1);
        Employee e3 = new Employee("Kim Doe", "kimdoe@example.com", d2);

        log.info("Preloading " + employeeRepository.save(e1));
        log.info("Preloading " + employeeRepository.save(e2));
        log.info("Preloading " + employeeRepository.save(e3));
      }
    };
  }
}
