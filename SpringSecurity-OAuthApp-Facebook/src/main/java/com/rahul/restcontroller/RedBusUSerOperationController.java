package com.rahul.restcontroller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusUSerOperationController {

	@GetMapping("/home")
	public String showHome() {

		return "Hello, Welcome to Home Page of RedBus.com";

	}

	@GetMapping("/after")
	public String fafterLoginPage() {

		return "Hello, Successfully loggen into RedBus.com";

	}

	@GetMapping("/user")
	public Authentication showUSerDetails(Principal principal) {

		System.out.println("Logged in Details :: " + principal.getName());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication;

	}

}
