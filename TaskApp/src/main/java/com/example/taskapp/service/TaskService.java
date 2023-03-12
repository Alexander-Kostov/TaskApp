package com.example.taskapp.service;

import com.example.taskapp.model.dto.CompletedTaskDTO;
import com.example.taskapp.model.dto.ShowTaskDTO;
import com.example.taskapp.model.dto.TaskDTO;
import com.example.taskapp.model.entity.ArchiveTasks;
import com.example.taskapp.model.entity.Employee;
import com.example.taskapp.model.entity.Task;
import com.example.taskapp.repository.ArchiveRepository;
import com.example.taskapp.repository.EmployeeRepository;
import com.example.taskapp.repository.TaskRepository;
import com.example.taskapp.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private List<CompletedTaskDTO> completedTaskDTOS;
    private TaskRepository taskRepository;

    private EmployeeRepository employeeRepository;

    private LoggedUser loggedUser;

    private ModelMapper modelMapper;
    private ArchiveRepository archiveRepository;

    public TaskService(List<CompletedTaskDTO> completedTaskDTOS, TaskRepository taskRepository, EmployeeRepository employeeRepository, LoggedUser loggedUser, ModelMapper modelMapper, ArchiveRepository archiveRepository) {
        this.completedTaskDTOS = completedTaskDTOS = new ArrayList<>();
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.archiveRepository = archiveRepository;
    }

    public boolean addTask(TaskDTO taskDTO) {

        Optional<Task> byTitle = this.taskRepository.findByTitle(taskDTO.getTitle());

        Optional<Employee> optUser = this.employeeRepository.findById(this.loggedUser.getId());

        Employee creator = optUser.get();

        if (byTitle.isPresent()) {
            return false;
        }

        Task task = new Task();

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setCreator(creator);

        this.taskRepository.save(task);

        return true;
    }

    public List<ShowTaskDTO> getAllTasks() {
        return this.taskRepository.findAll().stream().map(this::mapTaskToDto).collect(Collectors.toList());

    }

    public ShowTaskDTO mapTaskToDto(Task task) {
        ShowTaskDTO showTaskDTO = new ShowTaskDTO();

        showTaskDTO.setId(task.getId());
        showTaskDTO.setTitle(task.getTitle());
        showTaskDTO.setCreator(task.getCreator().getUsername());
        showTaskDTO.setDescription(task.getDescription());
        showTaskDTO.setDueDate(task.getDueDate());
        if (task.getAssignee() != null) {
            showTaskDTO.setAssignee(task.getAssignee().getUsername());
        }

        return showTaskDTO;
    }

    public List<ShowTaskDTO> getAllWorkingAssignments(Long id) {
        Optional<Employee> loggedUser = this.employeeRepository.findById(id);
        Employee user = loggedUser.get();

        return user.getAssigneeTasks().stream().map(this::mapTaskToDto).collect(Collectors.toList());
    }

    public List<ShowTaskDTO> getMyCreatedAssignments(Long id) {
        Optional<Employee> loggedUser = this.employeeRepository.findById(id);
        Employee user = loggedUser.get();

        return user.getCreatorTasks().stream().map(this::mapTaskToDto).collect(Collectors.toList());
    }

    public void completeTask(Long id) {
        Optional<Employee> loggedUser = this.employeeRepository.findById(this.loggedUser.getId());
        Employee user = loggedUser.get();

        Optional<Task> taskOpt = this.taskRepository.findById(id);
        Task completedTask = taskOpt.get();

        ArchiveTasks taskToArchive = this.modelMapper.map(completedTask, ArchiveTasks.class);
        taskToArchive.setDateOfDelete(LocalDate.now());
        taskToArchive.setAssignee(completedTask.getAssignee().getUsername());
        taskToArchive.setCreator(completedTask.getCreator().getUsername());
        taskToArchive.setSalary(500);
        user.setMonthlySalary(user.getMonthlySalary() + 500);

        user.getAssigneeTasks().remove(completedTask);
        this.archiveRepository.saveAndFlush(taskToArchive);

        this.employeeRepository.save(user);
        this.taskRepository.deleteById(id);


    }

    public CompletedTaskDTO mapTaskToTaskDTO (Task task) {
        CompletedTaskDTO completedTaskDTO = new CompletedTaskDTO();

        completedTaskDTO.setCompletedBy(task.getAssignee().getUsername());
        completedTaskDTO.setId(task.getId());
        completedTaskDTO.setTitle(task.getTitle());
        completedTaskDTO.setCreatedBy(task.getCreator().getUsername());
        completedTaskDTO.setDescription(task.getDescription());

        return completedTaskDTO;
    }

    public void addTaskToAssignments(Long id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(this.loggedUser.getId());
        Employee user = optionalEmployee.get();

        Optional<Task> optTask = this.taskRepository.findById(id);
        Task task = optTask.get();

        task.setAssignee(user);


        user.getAssigneeTasks().add(task);

        this.taskRepository.save(task);
    }
}
