package com.example.taskapp.web;

import com.example.taskapp.model.dto.TaskDTO;
import com.example.taskapp.service.TaskService;
import com.example.taskapp.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {

    private TaskService taskService;

    private LoggedUser loggedUser;

    public TaskController(TaskService taskService, LoggedUser loggedUser) {
        this.taskService = taskService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("taskDTO")
    public TaskDTO taskDTO() {
        return new TaskDTO();
    }

    @GetMapping("/task-add")
    public String addTask(){

        return "task-add";
    }


    @PostMapping("/task-add")
    public String addTask(@Valid TaskDTO taskDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        if(bindingResult.hasErrors() || !this.taskService.addTask(taskDTO)) {
            redirectAttributes.addFlashAttribute("taskDTO", taskDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskDTO", bindingResult);

            return "redirect:/task-add";
        }

        return "redirect:/home";

    }
}
