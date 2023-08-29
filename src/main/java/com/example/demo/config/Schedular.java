package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.auto.repository.MessageRepository;
//import com.example.demo.auto.repository.MessageRepository;
import com.example.demo.dr.repository.DrQuoteApplicantRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@EnableScheduling
public class Schedular {
	
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private DrQuoteApplicantRepository drQuoteApplicantRepository;
	
//	@Scheduled(fixedRate = 300000) // Run every 5 seconds
    public void performTask() {
		
		log.info("******************************");
		
		log.info("Auto :"+ messageRepository.findByCode("label.createclaimdeclaration.mobileNumber").getEn());
		log.info(" DR : "+drQuoteApplicantRepository.findAll().size());
		
		
      
    }

}
