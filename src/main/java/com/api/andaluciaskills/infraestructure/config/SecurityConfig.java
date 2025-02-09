package com.api.andaluciaskills.infraestructure.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/login", "/public/**")
                .permitAll()  // Acceso libre para login y rutas públicas
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")  // Solo ADMIN puede acceder a /admin/*
                .requestMatchers("/experto/**")
                .hasRole("EXPERTO")  // Solo EXPERTO puede acceder a /experto/*
                .anyRequest().authenticated()  // Cualquier otra ruta requiere autenticación
        )
        .formLogin(withDefaults())  // Utiliza la configuración por defecto para login
        .logout(withDefaults());  // Utiliza la configuración por defecto para logout

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();  // Usamos un encriptador de contraseñas seguro
  }

}