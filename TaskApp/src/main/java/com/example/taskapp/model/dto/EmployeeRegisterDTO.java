package com.example.taskapp.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class EmployeeRegisterDTO {
    @Size(min = 3, max = 20)
    @NotBlank
    private String username;
    @Size(min = 3, max = 20)
    @NotBlank
    private String firstName;
    @Size(min = 3, max = 20)
    @NotBlank
    private String lastName;
    @Size(min = 3, max = 20)
    @NotBlank
    private String password;
    @Size(min = 3, max = 20)
    @NotBlank
    private String confirmPassword;
    @Size(min = 2, max = 20)
    @NotBlank
    private String phoneNumber;

    @NotNull(message = "Date cannot be null")
    @PastOrPresent(message = "Date cannot be in future")
    private LocalDate dateOfBirth;

    public String getUsername() {
        return username;
    }

    public EmployeeRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EmployeeRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public EmployeeRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EmployeeRegisterDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public EmployeeRegisterDTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

}
