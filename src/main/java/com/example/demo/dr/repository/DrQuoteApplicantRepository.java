package com.example.demo.dr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dr.entity.DrQuoteApplicant;


@Repository
public interface DrQuoteApplicantRepository extends JpaRepository<DrQuoteApplicant, Integer>  {

	@Query(nativeQuery = true,name = "SELECT * FROM auto_quote_applicant where quotation_number =?1")
	DrQuoteApplicant findByQuotationNo(String quotationNo);

}
