package com.jobsTasks.jobsTasks.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobsTasks.jobsTasks.domain.Task;

@Component("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> findAllTasks() throws Exception{

		List<Task> list = (List<Task>)taskRepository.findAll();
		Collections.sort(list, (Task t1, Task t2) -> t1.getCreatedAt().compareTo(t2.getCreatedAt()));
		return list;
	}

	@Override
	public Task findById(Integer id) throws Exception{
		return taskRepository.findById(id).get();
	}

	@Override
	public Task saveTask(Task task) throws Exception{
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Integer id) throws Exception{
		taskRepository.deleteById(id);
	}

	@Override
	public Task updateTask(Task task, Integer id) throws Exception{

		if(taskRepository.findById(id) != null) {
			throw new Exception("Job already exists");
		}
		else {
			task.setId(id);
			return this.saveTask(task);
		}
	}

}
