package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final DbService dbService;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskController(DbService dbService, TaskMapper taskMapper) {
        this.dbService = dbService;
        this.taskMapper = taskMapper;
    }

    @GetMapping(value = "getTasks")
    public List<TaskDto> getTasks() {
        List<Task> tasks = dbService.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "getTask")
    public TaskDto getTask(@RequestParam long taskId) {
        Task task = dbService.getTaskById(taskId);
        return taskMapper.mapToTaskDto(task);
    }

    @DeleteMapping(value = "deleteTask")
    public void deleteTask(Long taskId) {

    }

    @PutMapping(value = "updateTask")
    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "Edited_title", "Edited_content");
    }

    @PutMapping(value = "createTask")
    public void createTask(TaskDto taskDto) {

    }
}
