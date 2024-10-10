/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.hospital_management.controller;

import com.hospital.hospital_management.model.Empleado;
import com.hospital.hospital_management.service.EmpleadoService;
import com.hospital.hospital_management.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "empleados/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@Valid @ModelAttribute Empleado empleado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "empleados/formulario";
        }
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        Empleado empleado = empleadoService.buscarPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado: " + id));
        model.addAttribute("empleado", empleado);
        return "empleados/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarEmpleado(@PathVariable("id") Long id, @Valid @ModelAttribute Empleado empleado, BindingResult result) {
        if (result.hasErrors()) {
            return "empleados/formulario";
        }
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable("id") Long id) {
        empleadoService.eliminar(id);
        return "redirect:/empleados";
    }
}