package com.rahul.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("Rahul").password("{noop}More").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("Krishna").password("{noop}heart").roles("MANAGER");

	}
	
/*	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(request -> request
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/offers").authenticated()
                        .requestMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")
                        .requestMatchers("/loanApprove").hasRole("MANAGER")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                		.loginPage("/login")
                		.permitAll())
                .logout(logout -> logout
                		.permitAll())
                .rememberMe(remember -> remember
                		.alwaysRemember(true))
                .exceptionHandling(exception -> exception
                		.accessDeniedPage("/denied"))
                .sessionManagement(management -> management
                		.maximumSessions(2)
                		.maxSessionsPreventsLogin(true));

		return http.build();
	}*/

	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/offers").authenticated()
		.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")
		.antMatchers("/loanApprove").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().rememberMe()
		.and().logout()
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);

		return http.build();
	}

}
