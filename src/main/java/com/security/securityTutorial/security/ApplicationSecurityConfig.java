package com.security.securityTutorial.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static javax.management.Query.and;

@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http
                .authorizeHttpRequests()
                 .requestMatchers("/", "index")
                 .permitAll()
                 .anyRequest()
                 .authenticated();
        return http.build();
    }
}
