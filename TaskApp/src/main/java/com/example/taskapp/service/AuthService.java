package com.example.taskapp.service;

import com.example.taskapp.model.dto.EmployeeRegisterDTO;
import com.example.taskapp.model.dto.LoginDTO;
import com.example.taskapp.model.entity.Employee;
import com.example.taskapp.repository.EmployeeRepository;
import com.example.taskapp.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private EmployeeRepository employeeRepository;

    private LoggedUser loggedUser;

    public AuthService(EmployeeRepository employeeRepository, LoggedUser loggedUser) {
        this.employeeRepository = employeeRepository;
        this.loggedUser = loggedUser;
    }

    public boolean register(EmployeeRegisterDTO registerDTO) {
        Optional<Employee> employeeOpt = this.employeeRepository.findByUsername(registerDTO.getUsername());

        if(employeeOpt.isPresent()){
            return false;
        }

        if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            return false;
        }

        Employee employee = new Employee();
        employee.setUsername(registerDTO.getUsername());
        employee.setPassword(registerDTO.getPassword());
        employee.setFirstName(registerDTO.getFirstName());
        employee.setLastName(registerDTO.getLastName());
        employee.setDateOfBirth(registerDTO.getDateOfBirth());
        employee.setPhoneNumber(registerDTO.getPhoneNumber());

        this.employeeRepository.save(employee);
        return true;
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<Employee> employeeOpt = this.employeeRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if(employeeOpt.isEmpty()) {
            return false;
        }

        Employee user = employeeOpt.get();

        this.loggedUser.login(user);

        return true;
    }
}
