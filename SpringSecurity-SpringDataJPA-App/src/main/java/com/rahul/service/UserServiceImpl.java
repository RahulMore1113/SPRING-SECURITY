package com.rahul.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rahul.repository.IUserDetailsRepo;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDetailsRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<com.rahul.model.UserDetails> optional = repo.findByUname(username);

		if (optional.isEmpty())
			throw new IllegalArgumentException("User not found");
		else {
			com.rahul.model.UserDetails details = optional.get();
			User user = new User(details.getUname(), 
					details.getPwd(), 
					details.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toSet())
			);
			return user;
		}


	}

	@Override
	public String register(com.rahul.model.UserDetails details) {

		details.setPwd(encoder.encode(details.getPwd()));

		return repo.save(details).getUid() + "user id saved";

	}

}
