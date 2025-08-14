package com.sensui.taskmanager.controller;

import com.sensui.taskmanager.model.entity.Task;
import com.sensui.taskmanager.model.request.CreateTaskRequest;
import com.sensui.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TaskController.BASE_PATH)
@RequiredArgsConstructor
public class TaskController {

    public static final String BASE_PATH = "/api/tasks";

    private final TaskService service;

    @PostMapping
    public Task createTask(
            @Valid @RequestBody CreateTaskRequest request) {
        return service.createTask(request);
    }

    @GetMapping
    public List<Task> listTasks() {
        return service.listTasks();
    }
}
