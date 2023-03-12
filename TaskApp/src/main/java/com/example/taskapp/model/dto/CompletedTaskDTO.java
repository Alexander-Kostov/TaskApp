package com.example.taskapp.model.dto;

public class CompletedTaskDTO {

    private Long id;

    private String title;

    private String description;

    private String completedBy;

    private String createdBy;

    public Long getId() {
        return id;
    }

    public CompletedTaskDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CompletedTaskDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompletedTaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public CompletedTaskDTO setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public CompletedTaskDTO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
