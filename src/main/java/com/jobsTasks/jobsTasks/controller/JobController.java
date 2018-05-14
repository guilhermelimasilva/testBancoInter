package com.jobsTasks.jobsTasks.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jobsTasks.jobsTasks.domain.Job;
import com.jobsTasks.jobsTasks.service.JobService;

@Controller
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	JobService jobService;

	private static final Logger logger = LoggerFactory.getLogger(JobController.class);

	@GetMapping("/")
	@ResponseBody
	public List<Job> getListJobs(@Param(value="orderByWeight") boolean orderByWeight) {
		try {
			return jobService.findAllJobs(orderByWeight);
		}catch(Exception e) {
			logger.error("Error occurred while trying to get list of Jobs", e);
			return new ArrayList<>();
		}
	}

	@GetMapping(value="/{id}")
	@ResponseBody
	public Job getJobById(@PathVariable(value="id") Integer id) {
		try {
			return jobService.findById(id);
		}catch(Exception e) {
			logger.error("Error occurred while trying to get a Job", e);
			return new Job();
		}
	}

	@PostMapping()
	@RequestMapping
	@ResponseBody
	public String createJob(@RequestBody Job job) {
		try {
			jobService.saveJob(job);
			return "Job created successfully";
		}
		catch(Exception e) {
			logger.error("Error occurred while trying to create a new Job", e);
			return "Error occurred while trying to create a new Job " + e.getMessage();
		}

	}

	@DeleteMapping(value="/{id}")
	@ResponseBody
	public String deleteJob(@PathVariable(value="id") Integer id) {
		try {
			jobService.deleteJob(id);
			return "Sucesso!";
		}catch(Exception e) {
			logger.error("Error occurred while trying to delete a Job", e);
			return "Error occurred while trying to delete a Job " + e.getMessage();
		}
	}

	@PutMapping(value="/{id}")
	@ResponseBody
	public String updateJob(@PathVariable(value="id") Integer id, @RequestBody Job job) {
		try {
			jobService.updateJob(job, id);
			return "Sucesso!";
		}catch(Exception e) {
			logger.error("Error occurred while trying to update a Job", e);
			return "Error occurred while trying to update a Job " + e.getMessage();
		}
	}


}
