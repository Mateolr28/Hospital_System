package com.hospital.hospital_management.config;

import com.hospital.hospital_management.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Lazy
    @Autowired
    private UsuarioService usuarioService; // Asegúrate de que no se inyecte aquí un bean de configuración

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Codificador de contraseñas
    }

   @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests()
            .requestMatchers("/register", "/login", "/resources/**").permitAll()  // Permitir acceso a login y registro
            .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud
            .and()
        .formLogin()
            .loginPage("/login")  // Página de inicio de sesión
            .defaultSuccessUrl("/home", true)  // Redirige a la página principal tras iniciar sesión
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")  // Redirige a login con mensaje de logout
            .permitAll();

    return http.build();  // Construir el filtro de seguridad
}
}
