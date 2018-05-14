package com.jobsTasks.jobsTasks.service;

import org.springframework.data.repository.CrudRepository;

import com.jobsTasks.jobsTasks.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{

}
