package com.jobsTasks.jobsTasks.service;

import java.util.List;

import com.jobsTasks.jobsTasks.domain.Task;

public interface TaskService {

	List<Task> findAllTasks() throws Exception;
	Task findById(Integer id) throws Exception;
	Task saveTask(Task task) throws Exception;
	void deleteTask(Integer id) throws Exception;
	Task updateTask(Task task, Integer id) throws Exception;
}
