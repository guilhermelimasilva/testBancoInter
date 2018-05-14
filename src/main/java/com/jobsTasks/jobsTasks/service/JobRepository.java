package com.jobsTasks.jobsTasks.service;

import org.springframework.data.repository.CrudRepository;
import com.jobsTasks.jobsTasks.domain.Job;

public interface JobRepository extends CrudRepository<Job, Integer>{

}
