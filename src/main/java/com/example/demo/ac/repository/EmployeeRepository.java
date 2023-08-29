package com.example.demo.ac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ac.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
