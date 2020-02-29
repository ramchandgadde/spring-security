package com.myapp.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("foo")
                .password("{noop}foo")
                .roles("USER_ROLE")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN_ROLE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().

                antMatchers("/admin*").hasRole("ADMIN_ROLE").
                antMatchers("/user*").hasAnyRole("USER_ROLE", "ADMIN_ROLE").
                antMatchers("/").permitAll().
                and().formLogin();


    }

}
