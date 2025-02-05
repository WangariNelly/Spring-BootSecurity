package com.security.securityTutorial.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static javax.management.Query.and;

@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http
                .authorizeRequests()
                 .requestMatchers("/", "index")
                 .permitAll()
                 .anyRequest()
                 .authenticated()
        .and()
                  .formLogin();

        return http.build();
    }
     @Bean
    protected UserDetailsService userDetailsService() {
         InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build());
         manager.createUser(User.withUsername("admin")
                 .password(passwordEncoder.encode("admin123"))
                 .roles("ADMIN")
                 .build());
         return manager;
     };
}
