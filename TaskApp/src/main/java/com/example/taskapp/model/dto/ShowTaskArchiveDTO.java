package com.example.taskapp.model.dto;

import java.time.LocalDate;

public class ShowTaskArchiveDTO {

    private Long id;

    private String title;

    private String description;

    private String creator;

    private String assignee;

    private LocalDate dueDate;

    private LocalDate dateOfDelete;

    public Long getId() {
        return id;
    }

    public ShowTaskArchiveDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ShowTaskArchiveDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ShowTaskArchiveDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ShowTaskArchiveDTO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public ShowTaskArchiveDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public ShowTaskArchiveDTO setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public LocalDate getDateOfDelete() {
        return dateOfDelete;
    }

    public ShowTaskArchiveDTO setDateOfDelete(LocalDate dateOfDelete) {
        this.dateOfDelete = dateOfDelete;
        return this;
    }
}
