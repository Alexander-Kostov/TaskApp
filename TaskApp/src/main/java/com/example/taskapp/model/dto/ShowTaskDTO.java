package com.example.taskapp.model.dto;

import java.time.LocalDate;

public class ShowTaskDTO {

    private Long id;

    private String title;

    private String description;

    private String creator;

    private String assignee;

    private LocalDate dueDate;

    public Long getId() {
        return id;
    }

    public ShowTaskDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ShowTaskDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ShowTaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ShowTaskDTO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public ShowTaskDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public ShowTaskDTO setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }
}
