package com.example.taskapp.web;

import com.example.taskapp.model.dto.EmployeeRegisterDTO;
import com.example.taskapp.model.dto.LoginDTO;
import com.example.taskapp.service.AuthService;
import com.example.taskapp.session.LoggedUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private AuthService authService;

    private LoggedUser loggedUser;

    public AuthController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("registerDTO")
    public EmployeeRegisterDTO registerDTO(){
        return new EmployeeRegisterDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO loginDTO(){
        return new LoginDTO();
    }

    @GetMapping("/login")
    public String login() {

        if (loggedUser.loggedIn()) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession httpSession) {

        if (loggedUser.loggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }

        if (!this.authService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }

        httpSession.setMaxInactiveInterval(9000000);

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register() {

        if (loggedUser.loggedIn()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid EmployeeRegisterDTO registerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (loggedUser.loggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors() || !this.authService.register(registerDTO)) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        this.loggedUser.logout();

        return "redirect:/";
    }



}
