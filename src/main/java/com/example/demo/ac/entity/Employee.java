package com.example.demo.ac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(nullable = false)
	  private Integer id;
	  
	  private String name;
	  
	  private String designation;

}
