package com.rahul.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	@Bean
	public SecurityFilterChain configureFilter(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.antMatchers("/","/home","/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login();
		
		return http.build();
		
	}

}
