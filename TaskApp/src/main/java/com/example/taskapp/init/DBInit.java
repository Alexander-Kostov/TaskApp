package com.example.taskapp.init;

import com.example.taskapp.model.entity.Employee;
import com.example.taskapp.model.entity.Task;
import com.example.taskapp.repository.EmployeeRepository;
import com.example.taskapp.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private EmployeeRepository employeeRepository;

    private TaskRepository taskRepository;

    public DBInit(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        seedEmployees();
        seedTasks();


    }

    private void seedEmployees() {
        List<Employee> employees = List.of(
                new Employee().setUsername("alex")
                        .setFirstName("alexander")
                        .setLastName("todorov")
                        .setDateOfBirth(LocalDate.of(2022, 1, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("rado")
                        .setFirstName("radoslav")
                        .setLastName("blagoev")
                        .setDateOfBirth(LocalDate.of(2022, 2, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("pesho")
                        .setFirstName("alexander")
                        .setLastName("todorov")
                        .setDateOfBirth(LocalDate.of(2022, 1, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("gosho")
                        .setFirstName("radoslav")
                        .setLastName("blagoev")
                        .setDateOfBirth(LocalDate.of(2022, 2, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("kiro")
                        .setFirstName("radoslav")
                        .setLastName("blagoev")
                        .setDateOfBirth(LocalDate.of(2022, 2, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("georgi")
                        .setFirstName("radoslav")
                        .setLastName("blagoev")
                        .setDateOfBirth(LocalDate.of(2022, 2, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("stoqn")
                        .setFirstName("radoslav")
                        .setLastName("blagoev")
                        .setDateOfBirth(LocalDate.of(2022, 2, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("vasko")
                        .setFirstName("radoslav")
                        .setLastName("blagoev")
                        .setDateOfBirth(LocalDate.of(2022, 2, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123"),

                new Employee().setUsername("petio")
                        .setFirstName("radoslav")
                        .setLastName("blagoev")
                        .setDateOfBirth(LocalDate.of(2022, 2, 1))
                        .setMonthlySalary(0)
                        .setPhoneNumber("3598847665213")
                        .setPassword("123")

        );


        this.employeeRepository.saveAll(employees);
    }

    private void seedTasks() {
        List<Task> allTasks = List.of(
                new Task()
                        .setTitle("first Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("alex").get()),

                new Task()
                        .setTitle("second Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("alex").get()),

                new Task()
                        .setTitle("third Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 3, 1))
                        .setCreator(this.employeeRepository.findByUsername("rado").get()),

                new Task()
                        .setTitle("fourth Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 5, 10))
                        .setCreator(this.employeeRepository.findByUsername("alex").get()),

                new Task()
                        .setTitle("fifth Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 12, 3))
                        .setCreator(this.employeeRepository.findByUsername("rado").get()),

                new Task()
                        .setTitle("sixth Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 7, 6))
                        .setCreator(this.employeeRepository.findByUsername("rado").get()),

                new Task()
                        .setTitle("seventh Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 4, 3))
                        .setCreator(this.employeeRepository.findByUsername("alex").get()),

                new Task()
                        .setTitle("eighth Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 9, 16))
                        .setCreator(this.employeeRepository.findByUsername("alex").get()),

                new Task()
                        .setTitle("ninth Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2023, 8, 16))
                        .setCreator(this.employeeRepository.findByUsername("rado").get()),

                new Task()
                        .setTitle("tenth Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 2, 1))
                        .setCreator(this.employeeRepository.findByUsername("alex").get()),

                new Task()
                        .setTitle("eleventh Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("kiro").get()),

                new Task()
                        .setTitle("12 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("13 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("14 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("15 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("16 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("17 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("18 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("19 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("20 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("21 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("22 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("23 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("24 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get()),

                new Task()
                        .setTitle("25 Task")
                        .setDescription("some description")
                        .setDueDate(LocalDate.of(2024, 5, 1))
                        .setCreator(this.employeeRepository.findByUsername("georgi").get())


                );

        this.taskRepository.saveAllAndFlush(allTasks);
    }
}
