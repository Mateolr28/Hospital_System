package com.hospital.hospital_management.controller;

import com.hospital.hospital_management.model.Rol;
import com.hospital.hospital_management.model.Usuario;
import com.hospital.hospital_management.service.RolService;
import com.hospital.hospital_management.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        List<Rol> roles = rolService.findAll(); // Cargar todos los roles
        model.addAttribute("roles", roles); // Agregar roles al modelo
        return "register"; 
    }

    @PostMapping("/register")
    public String registerUser(Usuario usuario) {
        System.out.println("Datos recibidos: " + usuario); // Verifica los datos recibidos

        // Convertir el rol de cadena a objeto Rol
        Rol rol = rolService.findByName(usuario.getRole().getName());
        if (rol != null) {
            usuario.setRole(rol);
        } else {
            // Maneja el caso en que el rol no existe
        }

        usuarioService.registerUser(usuario);
        return "redirect:/login"; 
    }
}
