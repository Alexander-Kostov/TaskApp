package com.example.taskapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "monthly_salary")
    private double monthlySalary;

    @OneToMany(mappedBy = "assignee", fetch = FetchType.EAGER)
    private List<Task> assigneeTasks;

    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    private List<Task> creatorTasks;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Employee setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Employee setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Employee setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public Employee setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
        return this;
    }

    public List<Task> getAssigneeTasks() {
        return assigneeTasks;
    }

    public Employee setAssigneeTasks(List<Task> assigneeTasks) {
        this.assigneeTasks = assigneeTasks;
        return this;
    }

    public List<Task> getCreatorTasks() {
        return creatorTasks;
    }

    public Employee setCreatorTasks(List<Task> creatorTasks) {
        this.creatorTasks = creatorTasks;
        return this;
    }
}
