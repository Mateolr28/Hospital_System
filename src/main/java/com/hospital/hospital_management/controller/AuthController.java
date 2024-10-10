package com.hospital.hospital_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Retorna la vista del login (login.html)
    }

    @GetMapping("/register")
    public String register() {
        return "register";  // Retorna la vista de registro (register.html)
    }

    @GetMapping("/home")
    public String home() {
        return "home";  // Retorna la vista de la página principal (home.html)
    }
}
