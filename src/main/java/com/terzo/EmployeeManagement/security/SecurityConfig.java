package com.terzo.EmployeeManagement.security;

import com.terzo.EmployeeManagement.Repository.UserRepository;
import com.terzo.EmployeeManagement.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;


@Configuration
public class SecurityConfig {


    private final UserRepository userRepository;

    @Autowired
    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   @Bean
   public UserDetailsService userDetailsService(DataSource dataSource) {
       JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
       userDetailsManager.setUsersByUsernameQuery("SELECT username, password, active FROM user_entity WHERE username = ?");
       userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, role FROM user_entity WHERE username = ?");
       return userDetailsManager;
   }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employee/new").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employee/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/auth/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/auth/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/auth/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
