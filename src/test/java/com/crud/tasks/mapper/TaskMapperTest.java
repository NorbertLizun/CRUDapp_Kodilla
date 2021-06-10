package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "Title 1", "Description 1");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, taskDto.getId());
        assertEquals("Title 1", taskDto.getTitle());
        assertEquals("Description 1", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        Task task1 = new Task(1L, "Title 1", "Description 1");
        Task task2 = new Task(2L, "Title 2", "Description 2");
        Task task3 = new Task(3L, "Title 3", "Description 3");
        Task task4 = new Task(4L, "Title 4", "Description 4");

        List<Task> taskList = Arrays.asList(task1, task2, task3, task4);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(4, taskDtoList.size());
        assertEquals(1L, taskDtoList.get(0).getId());
        assertEquals("Title 1", taskDtoList.get(0).getTitle());
        assertEquals("Description 1", taskDtoList.get(0).getContent());
        assertEquals(2L, taskDtoList.get(1).getId());
        assertEquals("Title 2", taskDtoList.get(1).getTitle());
        assertEquals("Description 2", taskDtoList.get(1).getContent());
        assertEquals(3L, taskDtoList.get(2).getId());
        assertEquals("Title 3", taskDtoList.get(2).getTitle());
        assertEquals("Description 3", taskDtoList.get(2).getContent());
        assertEquals(4L, taskDtoList.get(3).getId());
        assertEquals("Title 4", taskDtoList.get(3).getTitle());
        assertEquals("Description 4", taskDtoList.get(3).getContent());
    }

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Title 1", "Description 1");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //
        assertEquals(1L, task.getId());
        assertEquals("Title 1", task.getTitle());
        assertEquals("Description 1", task.getContent());
    }


}
