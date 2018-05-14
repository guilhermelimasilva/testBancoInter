package com.jobsTasks.jobsTasks.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobsTasks.jobsTasks.domain.Job;
import com.jobsTasks.jobsTasks.domain.Task;

@Component("jobService")
@Transactional
public class JobServiceImpl implements JobService{


	@Autowired
	JobRepository jobRepository;

	@Override
	public List<Job> findAllJobs(boolean orderByWeightOfTask) throws Exception{

		List<Job> list = (List<Job>) jobRepository.findAll();
		if(orderByWeightOfTask) {
			Collections.sort(list, (Job j1, Job j2) -> returnSumOfWeigths(j1.getTasks()).compareTo(returnSumOfWeigths(j2.getTasks()))* -1);
		}
		return list;
	}

	@Override
	public Job saveJob(Job job) throws Exception{

		if(job.getParentJob() != null) {
			job.setParentJob(this.findById(job.getParentJob().getId()));
		}
		if(verifyParentJob(job, job.getParentJob())) {		
			return jobRepository.save(job);
		} else {
			throw new Exception("Invalid Job Hierarchy");
		}
	}

	@Override
	public Job findById(Integer id) throws Exception{

		Optional<Job> optional = jobRepository.findById(id);
		return optional != null ? optional.get() : new Job();
	}

	@Override
	public Job updateJob(Job job, Integer id) throws Exception{

		if(jobRepository.findById(id) != null) {
			throw new Exception("Job already exists");
		}
		else {
			job.setId(id);
			return this.saveJob(job);
		}
	}

	@Override
	public void deleteJob(Integer id) throws Exception{

		jobRepository.deleteById(id);
	}

	private boolean verifyParentJob(Job job, Job parentJob) {

		if(parentJob != null && job.getId() == parentJob.getId()) {
			return false;
		}
		else if(parentJob != null && job.getId() != parentJob.getId()) {
			return verifyParentJob(job, parentJob.getParentJob());
		}
		return true;
	}

	private Double returnSumOfWeigths(List<Task> list) {
		return list != null && !list.isEmpty() ? list.stream().mapToDouble(w -> w.getWeight()).sum() : 0.0;
	}
}
