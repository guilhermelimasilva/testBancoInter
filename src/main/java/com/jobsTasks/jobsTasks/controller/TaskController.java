package com.jobsTasks.jobsTasks.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jobsTasks.jobsTasks.domain.Task;
import com.jobsTasks.jobsTasks.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService taskService;

	private static final Logger logger = LoggerFactory.getLogger(JobController.class);

	@GetMapping("/")
	@ResponseBody
	public List<Task> getListJobs() {
		try {
			return taskService.findAllTasks();
		}catch(Exception e) {
			logger.error("Error occurred while trying to get list of Tasks", e);
			return new ArrayList<>();
		}
	}

	@GetMapping(value="/{id}")
	@ResponseBody
	public Task getTaskById(@PathVariable(value="id") Integer id) {
		try {
			return taskService.findById(id);
		}catch(Exception e) {
			logger.error("Error occurred while trying to get a Task", e);
			return new Task();
		}
	}

	@PostMapping()
	@RequestMapping
	@ResponseBody
	public String insertTask(@RequestBody Task task) {
		try {
			taskService.saveTask(task);
			return "Sucesso!";
		}catch(Exception e) {
			logger.error("Error occurred while trying to create a new Task", e);
			return("Error occurred while trying to create a new Task " + e.getMessage());
		}
	}

	@DeleteMapping(value="/{id}")
	@ResponseBody
	public String deleteTask(@PathVariable(value="id") Integer id) {
		try {
			taskService.deleteTask(id);
			return "Sucesso!";
		}catch(Exception e) {
			logger.error("Error occurred while trying to delete a Task", e);
			return("Error occurred while trying to delete a new Tasks " + e.getMessage());
		}
	}

	@PutMapping(value="/{id}")
	@ResponseBody
	public String updateTask(@PathVariable(value="id") Integer id, @RequestBody Task task) {
		try {
			taskService.updateTask(task, id);
			return "Sucesso!";
		}catch(Exception e) {
			logger.error("Error occurred while trying to update a Task", e);
			return("Error occurred while trying to update a new Tasks " + e.getMessage());
		}
	}

}
