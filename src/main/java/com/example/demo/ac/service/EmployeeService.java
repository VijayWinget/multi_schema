package com.example.demo.ac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ac.entity.Employee;
import com.example.demo.ac.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	// create the list of Employees into the database who perform the task
	public void createEmployee() {

		if (employeeRepository.findAll().size() == 0) {

			employeeRepository.save(new Employee(0,"Prince", "Software Enginner"));
			employeeRepository.save(new Employee(0,"Gaurav", "Technical Lead"));
			employeeRepository.save(new Employee(0,"Abhinav", "Test Lead"));
		}
	}

}
