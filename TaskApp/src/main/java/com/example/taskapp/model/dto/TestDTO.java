package com.example.taskapp.model.dto;

public class TestDTO {

    private String assignedTo;
    private Long count;

    private double salary;

    public TestDTO() {
    }

    public TestDTO(String assignedTo, Long count, double salary) {
        this.assignedTo = assignedTo;
        this.count = count;
        this.salary = salary;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public TestDTO setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public Long getCount() {
        return count;
    }

    public TestDTO setCount(Long count) {
        this.count = count;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public TestDTO setSalary(double salary) {
        this.salary = salary;
        return this;
    }
}
