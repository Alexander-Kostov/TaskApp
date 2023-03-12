package com.example.taskapp.web;

import com.example.taskapp.model.dto.ShowTaskArchiveDTO;
import com.example.taskapp.model.dto.TestDTO;
import com.example.taskapp.service.StatService;
import com.example.taskapp.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StatsController {

    private final StatService statService;

    private LoggedUser loggedUser;

    public StatsController(StatService statService, LoggedUser loggedUser) {
        this.statService = statService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/stats")
    public String stats(Model model, Long month){

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        if(!model.containsAttribute("month")){
            model.addAttribute("month", month);
        }
        List<ShowTaskArchiveDTO> allArchivedTasks = this.statService.getAllArchivedTasks();


        List<TestDTO> topEmployees = this.statService
                .getTopEmployees(month == null ? LocalDate.now().getMonthValue() : month)
                .stream()
                .limit(5).toList();



        model.addAttribute("allArchivedTasks", allArchivedTasks);
        model.addAttribute("topEmployees", topEmployees);



        return "stats";
    }

}
