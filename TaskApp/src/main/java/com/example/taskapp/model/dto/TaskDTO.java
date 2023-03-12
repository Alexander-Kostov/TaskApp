package com.example.taskapp.model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class TaskDTO {
    @Size(min = 2, max = 15, message = "Title must be between 2 and 15 characters!")
    @NotNull(message = "Title cannot be empty!")
    private String title;
    @Size(max = 20)
    private String description;
    @FutureOrPresent(message = "Date cannot be in the past!")
    @NotNull(message = "Date cannot be empty!")
    private LocalDate dueDate;

    public String getTitle() {
        return title;
    }

    public TaskDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
