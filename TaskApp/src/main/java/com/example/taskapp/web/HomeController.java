package com.example.taskapp.web;

import com.example.taskapp.model.dto.ShowTaskDTO;
import com.example.taskapp.service.TaskService;
import com.example.taskapp.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private TaskService taskService;

    private LoggedUser loggedUser;

    public HomeController(TaskService taskService, LoggedUser loggedUser) {
        this.taskService = taskService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        List<ShowTaskDTO> allTasks = this.taskService.getAllTasks();
        List<ShowTaskDTO> workingAssignments = this.taskService.getAllWorkingAssignments(this.loggedUser.getId());
        List<ShowTaskDTO> createdAssignments = this.taskService.getMyCreatedAssignments(this.loggedUser.getId());

        model.addAttribute("workingAssignments", workingAssignments);
        model.addAttribute("createdAssignments", createdAssignments);
        model.addAttribute("allTasks", allTasks);


        return "home";
    }

    @GetMapping("/home/take-task/{id}")
    public String getTask(@PathVariable("id") Long id){
        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }
        this.taskService.addTaskToAssignments(id);

        return "redirect:/home";
    }

    @DeleteMapping("/home/finish-task/{id}")
    public String finishTask(@PathVariable("id") Long id){

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        this.taskService.completeTask(id);

        return "redirect:/home";
    }


}
