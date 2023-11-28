package com.rahul.test;

import com.rahul.util.JWTUtil;

import io.jsonwebtoken.Claims;

public class JWTTestApp {

	public static void main(String[] args) {

		String token = JWTUtil.generateToken("8723", "UPI-PIN", "SBI");
		System.out.println(token);

		Claims claims = JWTUtil.getClaims("SBI", token);
		System.out.println("Subject info :: " + claims.getSubject());
		System.out.println("Client Id :: " + claims.getId());
		System.out.println("Expiry Date :: " + claims.getExpiration());
		System.out.println("IssuedDate Time :: " + claims.getIssuedAt());

		System.out.println("Is Token Valid :: " + JWTUtil.isTokenValid("SBI", token));

		System.out.println("Subject is :: " + JWTUtil.getSubject("SBI", token));

		System.out.println("Expiry Date :: " + JWTUtil.getExpiryDate("SBI", token));

	}

}
