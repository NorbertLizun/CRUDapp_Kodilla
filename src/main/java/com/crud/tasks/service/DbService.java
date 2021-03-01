package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    private final TaskRepository taskRepository;

    public DbService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long taskId) {
        return taskRepository.findById(taskId);
    }
}
