package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiSchemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiSchemaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner init(final EmployeeService employeeService) {
//
//		return new CommandLineRunner() {
//			public void run(String... strings) throws Exception {
//				employeeService.createEmployee();
//			}
//		};
//	}
	
}
