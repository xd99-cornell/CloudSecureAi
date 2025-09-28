package com.cloudsecure.backend.controller;

import com.cloudsecure.backend.entity.User;
import com.cloudsecure.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @Autowired
    private AuthService authService;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String dashboard(Model model) {
        User currentUser = authService.getCurrentUser();
        if (currentUser != null) {
            model.addAttribute("user", currentUser);
        }
        return "dashboard";
    }
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(Model model) {
        User currentUser = authService.getCurrentUser();
        if (currentUser != null) {
            model.addAttribute("user", currentUser);
        }
        return "admin";
    }
}
