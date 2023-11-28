package com.rahul.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rahul.model.UserDetails;

public interface IUserDetailsRepo extends CrudRepository<UserDetails, Integer> {

	public Optional<UserDetails> findByUname(String uname);

}
