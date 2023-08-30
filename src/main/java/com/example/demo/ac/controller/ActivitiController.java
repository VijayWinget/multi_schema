package com.example.demo.ac.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ac.service.ProcessService;


@RestController
public class ActivitiController {
	
	
	@Autowired
	private ProcessService processService;

	/*
	 * Method will start the Activiti process engine and set employee to perform
	 * the task
	 */
//	http://localhost:8080/process?assignee=Prince
	@GetMapping(value = "/process")
	public String startProcessInstance(@RequestParam String assignee) {
		return processService.startTheProcess(assignee);
	}

	// Retrieve the tasks assigned to an employee
//	http://localhost:8080/tasks?assignee=Prince
	@GetMapping(value = "/tasks")
	public String getTasks(@RequestParam String assignee) {
		List<Task> tasks = processService.getTasks(assignee);
		return tasks.toString();
	}

	// Complete the task by their ID
//	http://localhost:8080/completetask?taskId=af8191e5-46f5-11ee-bb67-aa6bad4b266f
	@GetMapping(value = "/completetask")
	public String completeTask(@RequestParam String taskId) {
		processService.completeTask(taskId);
		return "Task with id " + taskId + " has been completed!";
	}
	
	
	
	
	
	
	
//	@Autowired
//	private ActivitiService activitiService;
//	
//	@GetMapping("/deploy")
//	public String deployWorkflow_() {
//		activitiService.deployWorkflow();
//		return "Workflow deployed successfully.";
//	}
//
//	@GetMapping("/start")
//	public String startWorkflow_() {
//		String processInstanceId = activitiService.startWorkflow();
//		return "Workflow started. Process Instance ID: " + processInstanceId;
//	}

}
