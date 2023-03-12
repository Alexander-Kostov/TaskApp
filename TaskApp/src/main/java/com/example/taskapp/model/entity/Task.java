package com.example.taskapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne()
    private Employee assignee;

    @ManyToOne
    private Employee creator;

    private LocalDate dueDate;

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public Task setAssignee(Employee assignee) {
        this.assignee = assignee;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Employee getCreator() {
        return creator;
    }

    public Task setCreator(Employee creator) {
        this.creator = creator;
        return this;
    }


}
