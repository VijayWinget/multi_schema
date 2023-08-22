package com.example.demo.dr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dr_quote_applicant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrQuoteApplicant  {
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(nullable = false)
	  private Integer id;
	  
	  @Column(name = "quotation_no")
	  private String quotationNo;

	  @Column(name = "salutation")
	  private String salutation;
	  
	  @Column(name = "firstname")
	  private String firstname;
	  
	  @Column(name = "surname")
	  private String surname;

	  @Column(name = "address1")
	  private String address1;
	  
	  @Column(name = "address2")
	  private String address2;

	  @Column(name = "city")
	  private String city;
	  
	  @Column(name = "country")
	  private String country;
	  
	  @Column(name = "postal_code")
	  private String postalCode;
	  
	  @Column(name = "email_id")
	  private String emailId;
	  
	  @Column(name = "customer_group_id")
	  private String customerGroupId;
	  
	  @Column(name = "phone")
	  private String phone;
	  
	  @Column(name = "mobile")
	  private String mobile;
	  
	  @Column(name = "date_of_birth")
	  private String dateOfBirth;
	  
	  @Column(name = "profession")
	  private String profession;
	  
	  @Column(name = "contact_type")
	  private String contactType;
	  
	  @Column(name = "created_date")
	  private String createdDate;
	  
	}
