package com.example.inventory_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disabled for demo purposes to allow Postman POSTs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/dashboard/**").authenticated() // Lock the web UI
                .anyRequest().permitAll() // Keep APIs open for your CLI/Postman
            )
            .formLogin(withDefaults()) // Enables the default login page
            .httpBasic(withDefaults()); // Allows CLI to authenticate via headers
            
        return http.build();
    }
}