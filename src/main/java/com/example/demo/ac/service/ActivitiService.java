package com.example.demo.ac.service;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitiService {

//	@Autowired
//	private ProcessEngine processEngine;
//
//	public void deployWorkflow() {
//		RepositoryService repositoryService = processEngine.getRepositoryService();
//		Deployment deployment = repositoryService.createDeployment()
//				.addClasspathResource("processes/simple-process.bpmn20.xml").deploy();
//		System.out.println("Deployment ID: " + deployment.getId());
//	}
//
//	public String startWorkflow() {
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("simpleProcess");
//		return processInstance.getId();
//	}

}
