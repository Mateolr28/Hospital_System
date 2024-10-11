package com.hospital.hospital_management.service;

import com.hospital.hospital_management.model.Usuario;
import com.hospital.hospital_management.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(Usuario usuario) {
        try {
            System.out.println("Registrando usuario: " + usuario.getUsername()); // Verifica el flujo
            
            String encodedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encodedPassword);
            usuarioRepository.save(usuario);
            System.out.println("Usuario registrado con éxito: " + usuario.getUsername());
        } catch (Exception e) {
          
            
        }
    }
}
