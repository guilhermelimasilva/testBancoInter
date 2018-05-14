package com.jobsTasks.jobsTasks.service;

import java.util.List;

import com.jobsTasks.jobsTasks.domain.Job;

public interface JobService {

	List<Job> findAllJobs(boolean orderByWeightOfTask) throws Exception;
	Job findById(Integer id) throws Exception;
	Job saveJob(Job job) throws Exception;
	void deleteJob(Integer id) throws Exception;
	Job updateJob(Job job, Integer id) throws Exception;
}
