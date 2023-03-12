package com.example.taskapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "archive_tasks")
public class ArchiveTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String assignee;

    private String creator;

    private LocalDate dueDate;

    private LocalDate dateOfDelete;

    private double salary;

    public Long getId() {
        return id;
    }

    public ArchiveTasks setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArchiveTasks setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArchiveTasks setDescription(String description) {
        this.description = description;
        return this;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }

    public ArchiveTasks setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }



    public LocalDate getDateOfDelete() {
        return dateOfDelete;
    }

    public ArchiveTasks setDateOfDelete(LocalDate dateOfDelete) {
        this.dateOfDelete = dateOfDelete;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public ArchiveTasks setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ArchiveTasks setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public ArchiveTasks setSalary(double salary) {
        this.salary = salary;
        return this;
    }
}
