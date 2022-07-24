package com.emrebozzkurtt.microserviceexample.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecuirtyConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.user.name}")
    private String SECURE_KEY_USERNAME;

    @Value("${spring.security.user.password}")
    private String SECURE_KEY_PASSWORD;

    @Value("${spring.security.user.roles}")
    private String SECURE_KEY_ROLE;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser(SECURE_KEY_USERNAME)
                .password(encoder.encode(SECURE_KEY_PASSWORD))
                .roles(SECURE_KEY_ROLE);
        super.configure(auth);
    }

    @Override
        public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();

    }
}
