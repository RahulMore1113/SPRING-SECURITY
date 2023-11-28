package com.rahul.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rahul.model.UserDetails;

public interface IUserService extends UserDetailsService {

	public String register(UserDetails details);

}
