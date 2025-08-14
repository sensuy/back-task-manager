package com.sensui.taskmanager.service;

import com.sensui.taskmanager.model.entity.Task;
import com.sensui.taskmanager.model.request.CreateTaskRequest;
import com.sensui.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public Task createTask(CreateTaskRequest request) {
        return repository.save(request.convertToTask());
    }

    public List<Task> listTasks() {
        return repository.findAll();
    }
}
