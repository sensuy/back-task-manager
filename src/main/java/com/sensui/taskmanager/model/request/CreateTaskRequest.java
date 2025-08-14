package com.sensui.taskmanager.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sensui.taskmanager.model.entity.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateTaskRequest(
        @NotNull
        @NotBlank
        @NotEmpty
        String title, Boolean completed) {

    public Task convertToTask() {
        return new Task().setTitle(title).setCompleted(completed);
    }
}
