package com.hospital.hospital_management.controller;

import com.hospital.hospital_management.model.Usuario; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";  
    }

    @GetMapping("/auth/register") 
public String showAuthRegistrationForm(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "register"; 
}

    @GetMapping("/home")
    public String home() {
        return "home";  
    }
}
