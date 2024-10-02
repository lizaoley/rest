package com.liza.sec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurityConfiguration {

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//
//        UserDetails anna = User.builder().username("Anna").password("{noop}anna123").roles("USER").build();
//        UserDetails ami = User.builder().username("Ami").password("{noop}ami123").roles("USER", "MANAGER").build();
//        UserDetails mark = User.builder().username("Mark").password("{noop}mark123").roles("USER", "MANAGER", "ADMIN").build();
//
//        return new InMemoryUserDetailsManager(anna, ami, mark);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select employee_name, password, enabled from employee where employee_name=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select employee_name, role from roles where employee_name=?");



        return jdbcUserDetailsManager; // вместо верхнего кода подключили базу данных с пользователями и их паролями
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("USER")
                                .requestMatchers("/managers/**").hasRole("MANAGER")
                                .requestMatchers("/admins/**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .formLogin(form ->
                        form.loginPage("/myLoginPage")
                                .loginProcessingUrl("/authenticateUser")
                                .permitAll())
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(exception -> exception.accessDeniedPage("/access-denied-page")
                );

        return http.build();
    }
}
